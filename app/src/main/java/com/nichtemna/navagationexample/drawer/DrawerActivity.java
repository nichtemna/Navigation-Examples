package com.nichtemna.navagationexample.drawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.nichtemna.navagationexample.R;

public class DrawerActivity extends AppCompatActivity implements IDrawerActivityController {
    private DrawerLayout drawerLayout;
    private FragmentLauncher fragmentLauncher;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, DrawerActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        fragmentLauncher = new FragmentLauncher(R.id.frameLayout, getSupportFragmentManager());
        initViews();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        invalidateOptionsMenu();
        fragmentLauncher.launchFragmentByPositionInDrawer(position);
        closeDrawer();
    }

    @Override
    public void openDrawer() {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void closeDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    private void initViews() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }
}
