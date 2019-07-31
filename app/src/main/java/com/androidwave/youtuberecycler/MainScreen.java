package com.androidwave.youtuberecycler;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {
    private static final long SLIDER_TIMER = 1000; // slider interval
    private int currentPage = 0; // this will tell us the current page available on the view pager


    private boolean isCountDownTimerActive = false; // check if it has completed previous task


    private Handler handler;
    private ViewPager viewPager;

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if (!isCountDownTimerActive) {
                automateSlider();
            }

            handler.postDelayed(runnable, 1000);
        }
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

        setContentView(R.layout.activity_main_screen);

        handler = new Handler();

        handler.postDelayed(runnable, 1000);
        runnable.run();

        viewPager = findViewById(R.id.view_pager_slider);

        CustomViewPagerAdapter viewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    currentPage = 0;
                } else if (position == 1) {
                    currentPage = 1;
                } else if (position == 2){
                    currentPage = 2;
                } else if (position == 3){
                    currentPage = 3;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



//        Buttonnssss


        findViewById(R.id.helping_hand).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainScreen.this, "Helping hand app", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.youtube).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainScreen.this, "Youtube channel", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.insta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainScreen.this, "Instagram handle", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.courses).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainScreen.this, "Courses", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainScreen.this, cources_list.class));
            }
        });
    }

    private void automateSlider() {
        isCountDownTimerActive = true;
        new CountDownTimer(SLIDER_TIMER, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                int nextSlider = currentPage + 1;



                if (nextSlider == 4) {
                    nextSlider = 0; // if it's last, go to the first image
                }

                viewPager.setCurrentItem(nextSlider);
                isCountDownTimerActive = false;
            }
        }.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
        // Kill this background task once the activity has been killed

    }
}