package com.nichtemna.navagationexample.drawer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nichtemna.navagationexample.R;

import java.util.ArrayList;

/**
 * Created by root on 16.05.14.
 */
public class NavigationAdapter extends ArrayAdapter<String> {
    private LayoutInflater layoutInflater;
    private ArrayList<String> titles;
    private ArrayList<Integer> drawables;

    public NavigationAdapter(Context pContext, ArrayList<String> titles, ArrayList<Integer> drawables) {
        super(pContext, 0, titles);
        this.titles = titles;
        this.drawables = drawables;
        layoutInflater = LayoutInflater.from(pContext);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_navigation, parent, false);
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.textView.setText(titles.get(position));
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), drawables.get(position)));

        return convertView;
    }

    static class Holder {
        TextView textView;
        ImageView imageView;
    }
}
