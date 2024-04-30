package com.fateh.beshno_as_naiy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<PoemModel> {

    // invoke the suitable constructor of the ArrayAdapter class
    public ListViewAdapter(Context context, ArrayList<PoemModel> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.poem_item, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        PoemModel currentPoemPosition = getItem(position);

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView title = currentItemView.findViewById(R.id.poem_title);
        title.setText(currentPoemPosition.getPoem_title());

        // then return the recyclable view
        return currentItemView;
    }
}