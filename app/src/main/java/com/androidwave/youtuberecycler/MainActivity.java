package com.androidwave.youtuberecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.androidwave.youtuberecycler.adapter.YoutubeRecyclerAdapter;
import com.androidwave.youtuberecycler.model.YoutubeVideo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewFeed)
    RecyclerView recyclerViewFeed;

    YoutubeRecyclerAdapter mRecyclerAdapter;

    String[] id={"WTtraF0FAv0","8ZK_S-46KwE","0VuCCTqoBIA","YrQVYEb6hcc","WTtraF0FAv0"};
    String[] title={"title1","title2","title3","title4","title5"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        try{
            getSupportActionBar().hide();

        } catch(Exception e){}

        TextView titleBar = findViewById(R.id.title_bar);
        titleBar.setText(getIntent().getStringExtra("title"));


        ButterKnife.bind(this);
        // prepare data for list
        List<YoutubeVideo> youtubeVideos = prepareList();
        mRecyclerAdapter = new YoutubeRecyclerAdapter(youtubeVideos);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewFeed.setLayoutManager(mLayoutManager);
        recyclerViewFeed.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFeed.setAdapter(mRecyclerAdapter);
    }

    private List<YoutubeVideo> prepareList() {
        ArrayList mYoutubeVideo = new ArrayList();
        // add first item
        for(int i=0; i<id.length; i++) {
            YoutubeVideo video1 = new YoutubeVideo();
            video1.setId((long) i+1);
            video1.setImageUrl("https://i.ytimg.com/vi/"+id[i]+"/maxresdefault.jpg");
            video1.setTitle(title[i]);
            video1.setVideoId(id[i]);
            mYoutubeVideo.add(video1);
        }
        return mYoutubeVideo;
    }
}
