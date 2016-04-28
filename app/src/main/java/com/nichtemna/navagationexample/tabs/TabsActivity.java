package com.nichtemna.navagationexample.tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.nichtemna.navagationexample.R;

/**
 * Created by Lina Shyshova on 27.04.16.
 */
public class TabsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private PagerAdapter pagerAdapter;

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, TabsActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        initViews();
    }

    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        pagerAdapter = new PagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(R.drawable.selector_navigation_tabs);
        }
    }
}
