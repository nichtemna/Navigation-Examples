package com.nichtemna.navagationexample.drawer;

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

/**
 * Created by Lina Shyshova on 28.04.16.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    protected FragmentLauncher launcher;
    protected IDrawerActivityController activityController;
    private Toolbar toolbar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityController = (IDrawerActivityController) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement IDrawerActivityController");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolbar(view);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activityController = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageview_hamburger:
                openDrawer();
                break;
            default:
        }
    }

    public void setLauncher(FragmentLauncher launcher) {
        this.launcher = launcher;
    }

    private void openDrawer() {
        if (activityController != null) {
            activityController.openDrawer();
        }
    }

    private void setToolbar(View pView) {
        toolbar = (Toolbar) pView.findViewById(R.id.toolbar);

        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            TextView textView = (TextView) toolbar.findViewById(R.id.textview_title);
            textView.setText(getString(getTitleResId()).toUpperCase());
        }

        ImageView hamburger = (ImageView) pView.findViewById(R.id.imageview_hamburger);
        if (hamburger != null) {
            hamburger.setOnClickListener(this);
        }
    }

    protected abstract int getTitleResId();
}
