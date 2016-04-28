package com.nichtemna.navagationexample.drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nichtemna.navagationexample.R;

public class TestDrawerFragment extends BaseFragment {
    public static final String ARG_TITLE = "title";
    private TextView textView;

    public static TestDrawerFragment newInstance(int titleResId) {
        TestDrawerFragment fragment = new TestDrawerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_TITLE, titleResId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test_drawer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(getTitleResId());
    }

    @Override
    protected int getTitleResId() {
        if (getArguments() != null && getArguments().containsKey(ARG_TITLE)) {
            return getArguments().getInt(ARG_TITLE);
        }
        return R.string.empty_string;
    }
}
