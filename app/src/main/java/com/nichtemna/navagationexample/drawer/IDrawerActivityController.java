package com.nichtemna.navagationexample.drawer;

/**
 * Created by Lina Shyshova on 28.04.16.
 */
public interface IDrawerActivityController {
    void onNavigationDrawerItemSelected(int position);

    void openDrawer();

    void closeDrawer();
}
