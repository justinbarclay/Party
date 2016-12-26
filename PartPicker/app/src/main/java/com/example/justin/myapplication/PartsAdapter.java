package com.example.justin.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Justin on 2016-12-26.
 */

public class PartsAdapter extends ArrayAdapter<HashMap<String, String>> {

    public PartsAdapter(Context ctx, ArrayList<HashMap<String, String>> posts) {

        super(ctx, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HashMap<String,String> part = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.part_list_item, parent, false);

        TextView partName = (TextView) convertView.findViewById(R.id.name);
        partName.setText(part.get("name"));

        return convertView;
    }
}