package com.nichtemna.navagationexample.tabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nichtemna.navagationexample.R;

import java.util.ArrayList;

/**
 * Created by Shyshova Lina
 * nichtemna@gmail.com
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private ArrayList<Fragment> fragments;

    public PagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
        fragments = getFragmentsList();
    }

    private ArrayList<Fragment> getFragmentsList() {
        ArrayList<Fragment> mFragments = new ArrayList<>();

        mFragments.add(TestFragment.newInstance());
        mFragments.add(TestFragment.newInstance());
        mFragments.add(TestFragment.newInstance());

        return mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.tab_1).toUpperCase();
            case 1:
                return context.getString(R.string.tab_2).toUpperCase();
            case 2:
                return context.getString(R.string.tab_3).toUpperCase();
            default:
        }
        return null;
    }
}