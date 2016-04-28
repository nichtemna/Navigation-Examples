package com.nichtemna.navagationexample.bottom_ios_style;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lina Shyshova on 09.03.16.
 */
public class NavigationView extends LinearLayout implements NavigationButton.OnCheckedChangeListener {
    private NavigationButton checkedButton;
    private List<NavigationButton> buttonList;
    private OnSwitchListener onSwitchListener;

    public NavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        setGravity(HORIZONTAL);
        buttonList = new ArrayList<>();
    }

    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        if (child instanceof NavigationButton) {
            NavigationButton button = (NavigationButton) child;
            button.setOnCheckedChangeListener(this);
            buttonList.add(button);
        }
        super.addView(child, index, params);
    }

    /**
     * if some button was checked, we uncheck the previous one
     */
    @Override
    public void onCheckedChanged(NavigationButton toggleButton) {
        if (checkedButton != null) {
            checkedButton.setChecked(false);
        }

        checkedButton = toggleButton;
        if (onSwitchListener != null) {
            onSwitchListener.onSwitch(getCheckedPosition());
        }
    }

    /**
     * @return the position of checked item
     */
    public int getCheckedPosition() {
        int position = 0;
        for (int i = 0; i < buttonList.size(); i++) {
            if (buttonList.get(i).equals(checkedButton)) {
                position = i;
            }
        }
        return position;
    }

    /**
     * Change checked item
     *
     * @param position - position of item that must be checked
     */
    public void setCheckedPosition(int position) {
        if (position > buttonList.size() - 1) {
            throw new IllegalArgumentException("No such position in NavigationView: " + position);
        } else {
            if (!buttonList.get(position).isChecked()) {
                buttonList.get(position).setChecked(true);
                onCheckedChanged(buttonList.get(position));
            }
        }
    }

    public void setOnSwitchListener(OnSwitchListener onSwitchListener) {
        this.onSwitchListener = onSwitchListener;
    }

    public interface OnSwitchListener {
        void onSwitch(int position);
    }
}