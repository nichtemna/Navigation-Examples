package com.nichtemna.navagationexample;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Lina Shyshova on 27.04.16.
 */
public class Enums {
    public enum MenuItem {
        FIRST(0, R.string.first, R.drawable.selector_navigation_drawer),
        SECOND(1, R.string.second, R.drawable.selector_navigation_drawer),
        THIRD(2, R.string.third, R.drawable.selector_navigation_drawer),
        FORTH(3, R.string.forth, R.drawable.selector_navigation_drawer),
        FIFTH(4, R.string.fifth, R.drawable.selector_navigation_drawer);

        int mPosition;
        int mTitleResId;
        int mImageResId;

        MenuItem(int pPosition, int pTitleResId, int pImageResId) {
            mPosition = pPosition;
            mTitleResId = pTitleResId;
            mImageResId = pImageResId;
        }

        public int getPosition() {
            return mPosition;
        }

        public int getTitleResId() {
            return mTitleResId;
        }

        public int getImageResId() {
            return mImageResId;
        }

        public static ArrayList<String> getTitlesArray(Context pContext) {
            ArrayList<String> titleList = new ArrayList<>(MenuItem.values().length);
            for (int i = 0; i < MenuItem.values().length; i++) {
                titleList.add(pContext.getString(MenuItem.values()[i].getTitleResId()));
            }
            return titleList;
        }

        public static ArrayList<Integer> getDrawablesArray() {
            ArrayList<Integer> drawablesList = new ArrayList<>(MenuItem.values().length);
            for (int i = 0; i < MenuItem.values().length; i++) {
                drawablesList.add(MenuItem.values()[i].getImageResId());
            }
            return drawablesList;
        }
    }
}
