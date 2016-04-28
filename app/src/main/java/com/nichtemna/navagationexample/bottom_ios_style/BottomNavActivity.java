package com.nichtemna.navagationexample.bottom_ios_style;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nichtemna.navagationexample.R;

public class BottomNavActivity extends AppCompatActivity implements NavigationView.OnSwitchListener {
    private NavigationView navigationView;
    private FragmentLauncher fragmentLauncher;
    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, BottomNavActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentLauncher = new FragmentLauncher(R.id.frameLayout, getSupportFragmentManager());
        setContentView(R.layout.activity_bottom_nav);
        initViews();
    }

    private void initViews() {
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setOnSwitchListener(this);
        navigationView.setCheckedPosition(0);
    }

    @Override
    public void onSwitch(int position) {
        fragmentLauncher.launchFragmentByPositionInDrawer(position);
    }
}
