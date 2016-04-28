package com.nichtemna.navagationexample.drawer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nichtemna.navagationexample.Enums;
import com.nichtemna.navagationexample.R;

public class DrawerFragment extends Fragment {
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
    private IDrawerActivityController activityController;
    private ListView listView;
    private int selectedPosition = 0;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            selectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        selectItem(selectedPosition);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activityController = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, selectedPosition);
    }

    private void initViews(View view) {
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new NavigationAdapter(getActivity().getBaseContext(), Enums.MenuItem.getTitlesArray(getActivity()),
                Enums.MenuItem.getDrawablesArray()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });
    }

    private void selectItem(int position) {
        selectedPosition = position;
        if (listView != null) {
            listView.setItemChecked(selectedPosition, true);
        }
        if (activityController != null) {
            activityController.onNavigationDrawerItemSelected(position);
        }
    }

}
