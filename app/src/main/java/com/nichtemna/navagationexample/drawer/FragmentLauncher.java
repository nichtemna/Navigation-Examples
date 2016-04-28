package com.nichtemna.navagationexample.drawer;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.nichtemna.navagationexample.Enums;
import com.nichtemna.navagationexample.R;

public class FragmentLauncher {
    private final FragmentManager fragmentManager;
    private int containerViewId;

    public FragmentLauncher(int containerViewId, FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.containerViewId = containerViewId;
    }

    private void launch(BaseFragment fragment, boolean addToBackStack) {
        fragment.setLauncher(this);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }

        try {
            fragmentTransaction.commit();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public BaseFragment getCurrentFragment() {
        return (BaseFragment) fragmentManager.findFragmentById(R.id.frameLayout);
    }

    public void launchTestFragment(int titleResId) {
        launch(TestDrawerFragment.newInstance(titleResId), false);
    }

    public void launchFragmentByPositionInDrawer(int pPosition) {
        switch (pPosition) {
            case 0:
                launchTestFragment(Enums.MenuItem.values()[pPosition].getTitleResId());
                break;

            case 1:
                launchTestFragment(Enums.MenuItem.values()[pPosition].getTitleResId());
                break;

            case 2:
                launchTestFragment(Enums.MenuItem.values()[pPosition].getTitleResId());
                break;

            case 3:
                launchTestFragment(Enums.MenuItem.values()[pPosition].getTitleResId());
                break;

            case 4:
                launchTestFragment(Enums.MenuItem.values()[pPosition].getTitleResId());
                break;

            default:
                throw new IllegalArgumentException("No launch option for position: " + pPosition);
        }
    }
}


