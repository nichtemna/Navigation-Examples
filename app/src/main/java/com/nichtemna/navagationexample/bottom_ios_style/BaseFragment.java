package com.nichtemna.navagationexample.bottom_ios_style;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nichtemna.navagationexample.R;
import com.nichtemna.navagationexample.drawer.IDrawerActivityController;

/**
 * Created by Lina Shyshova on 28.04.16.
 */

public abstract class BaseFragment extends Fragment{
    protected FragmentLauncher launcher;
    private Toolbar toolbar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolbar(view);
    }

    public void setLauncher(FragmentLauncher launcher) {
        this.launcher = launcher;
    }

    private void setToolbar(View pView) {
        toolbar = (Toolbar) pView.findViewById(R.id.toolbar);

        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            TextView textView = (TextView) toolbar.findViewById(R.id.textview_title);
            textView.setText(getString(getTitleResId()).toUpperCase());
        }
    }

    protected abstract int getTitleResId();
}
