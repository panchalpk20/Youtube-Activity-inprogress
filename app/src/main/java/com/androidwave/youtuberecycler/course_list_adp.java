package com.androidwave.youtuberecycler;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class course_list_adp extends ArrayAdapter<String>{


    private final Activity context;
    private final String[] web; // titless
    private final Integer[] imageId;
    public course_list_adp(Activity context,
                      String[] web, Integer[] imageId) {
        super(context, R.layout.course_list_item, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.course_list_item, null, true);
        TextView txtTitle = rowView.findViewById(R.id.title);

        ImageView imageView = rowView.findViewById(R.id.thumb);
        txtTitle.setText(web[position]); //setting title

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
