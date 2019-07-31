package com.androidwave.youtuberecycler;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class topic_list_adp extends ArrayAdapter <String> {
    Activity context;
    String[] title;
    public topic_list_adp(Activity context, String[] myDataset) {
        super(context,R.layout.course_list_item, myDataset );
        this.title = myDataset;
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.topic_list_item, null, true);
        TextView txtTitle = rowView.findViewById(R.id.title);

        txtTitle.setText(title[position]); //setting title

        return rowView;
    }
}
