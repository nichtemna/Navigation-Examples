package com.nichtemna.navagationexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.nichtemna.navagationexample.bottom_ios_style.BottomNavActivity;
import com.nichtemna.navagationexample.drawer.DrawerActivity;
import com.nichtemna.navagationexample.tabs.TabsActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.button_tabs).setOnClickListener(this);
        findViewById(R.id.button_drawer).setOnClickListener(this);
        findViewById(R.id.button_bottom_nav).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_tabs:
                TabsActivity.start(MainActivity.this);
                break;

            case R.id.button_drawer:
                DrawerActivity.start(MainActivity.this);
                break;

            case R.id.button_bottom_nav:
                BottomNavActivity.start(MainActivity.this);
                break;
            default:
                Log.d(getLocalClassName(), "No such option " + v.getId());
        }
    }
}
