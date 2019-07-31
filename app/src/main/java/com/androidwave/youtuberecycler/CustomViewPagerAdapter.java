package com.androidwave.youtuberecycler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CustomViewPagerAdapter extends FragmentStatePagerAdapter {

    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        if (position == 0) {
            fragment = new slide1();
        } else if (position == 1) {
            fragment = new slide2();
        } else if (position == 2) {
            fragment = new slide3();
        } else {
            fragment = new slide4();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        // return the number of your fragments,
        // we have 3 fragments
        return 4;
    }
}