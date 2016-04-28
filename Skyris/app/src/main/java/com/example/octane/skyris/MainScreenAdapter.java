package com.example.octane.skyris;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Octane on 2/26/2016.
 */
public class MainScreenAdapter extends BaseAdapter {
    private ArrayList<Integer> elementIds;

    private LayoutInflater mInflater;

    public MainScreenAdapter(Context context, ArrayList<Integer> ids) {
        elementIds = ids;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return elementIds.size();
    }

    public Object getItem(int position) {
        return elementIds.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        convertView = mInflater.inflate(R.layout.main_screen_tile, null);
        return convertView;


    }

}