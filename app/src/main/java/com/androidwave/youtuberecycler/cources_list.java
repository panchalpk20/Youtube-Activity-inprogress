package com.androidwave.youtuberecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class cources_list extends AppCompatActivity {

    ListView list;

    String[] titles ={
           "title 1",
           "title 2",
           "title 3",
           "title 4",
           "title 5",
           "title 6",
           "title 7",
           "title 8"
    };

    Integer[] thumbnails={
            R.drawable.thumb,
            R.drawable.thumb,
            R.drawable.thumb,
            R.drawable.thumb,
            R.drawable.thumb,
            R.drawable.thumb,
            R.drawable.thumb,
            R.drawable.thumb
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cources_list);
        try{
            getSupportActionBar().hide();

        } catch(Exception e){}

        TextView titleBar = findViewById(R.id.title_bar);
        titleBar.setText("Title Here");



        course_list_adp adapter = new course_list_adp(cources_list.this, titles, thumbnails);
        list=findViewById(R.id.course_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(cources_list.this, "You Clicked at " +titles[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(cources_list.this, PlayYoutubeActivity.class);
                intent.putExtra("title",titles[position]);
                startActivity(intent);
            }
        });

    }

}