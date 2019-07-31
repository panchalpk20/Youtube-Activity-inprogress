package com.androidwave.youtuberecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayYoutubeActivity extends YouTubeBaseActivity {

    public static final String YT_API_KEY = "AIzaSyAExTpjo40Mod4ig_JISnxGmlJYOE3lsds";


    private String[] myDataset={"Topic1","Topic2","Topic3","Topic4","Topic5","Topic6","Topic7","Topic8","Topic9","Topic10"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cources_list);

//        getActionBar().setTitle(getIntent().getStringExtra("title"));
        setContentView(R.layout.activity_play_youtube);

        TextView title = findViewById(R.id.course_title);
                title.setText(getIntent().getStringExtra("title"));


//----------------------------------------------video player-----------------------------------------
        YouTubePlayerView youTubePlayerView = findViewById(R.id.player);
        youTubePlayerView.initialize(YT_API_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc.
                        //youTubePlayer.cueVideo("5xVh-7ywKpE");
                        youTubePlayer.cueVideo("fGRStkp4VLA");
                        // or to play immediately
                        // youTubePlayer.loadVideo("5xVh-7ywKpE");
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {
                        Toast.makeText(PlayYoutubeActivity.this, "Youtube Failed!", Toast.LENGTH_SHORT).show();
                    }
                });


        //----------------------------------------List view-----------------------------------------

        ListView listView = findViewById(R.id.my_list);
        @SuppressWarnings("unchecked")
//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,myDataset);
//        listView.setAdapter(adapter);

//                        course_list_adp adapter = new course_list_adp(cources_list.this, titles, thumbnails);
        topic_list_adp adapter = new topic_list_adp(PlayYoutubeActivity.this, myDataset);

        listView.setAdapter(adapter);




        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(),
                    "Click on" + position+" item: "+myDataset[position], Toast.LENGTH_SHORT)
                    .show();


            Intent intent = new Intent(PlayYoutubeActivity.this, MainActivity.class);
            intent.putExtra("title", myDataset[position]);
            startActivity(intent);
        });




    }
}
