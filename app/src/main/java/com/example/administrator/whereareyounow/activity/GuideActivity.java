package com.example.administrator.whereareyounow.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.whereareyounow.R;
import com.example.administrator.whereareyounow.adapter.ViewPagerAdapter;
import com.example.administrator.whereareyounow.fragment.Fragment1;
import com.example.administrator.whereareyounow.fragment.Fragment2;
import com.example.administrator.whereareyounow.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends FragmentActivity {

    int[] imgs = {
            R.drawable.guide1,
            R.drawable.guide2,
            R.drawable.guide3,

    };
    private List<View> listImg;
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), showView()));
        listImg = new ArrayList<View>();
        listImg.add(findViewById(R.id.y1));
        listImg.add(findViewById(R.id.y2));
        listImg.add(findViewById(R.id.y3));
        pager.setOnPageChangeListener(showPageChange);
    }
    ViewPager.OnPageChangeListener showPageChange = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0) {
            for (int i = 0; i < listImg.size(); i++) {
                if (i == arg0) {
                    listImg.get(arg0).setBackgroundResource(R.drawable.guide_yellow);
                } else {
                    listImg.get(i).setBackgroundResource(R.drawable.guide_white);
                }
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }
    };
    private List<Fragment> showView() {
        List<Fragment> listView = new ArrayList<Fragment>();
        listView.add(new Fragment1());
        listView.add(new Fragment2());
        listView.add(new Fragment3());
        return listView;
    }
}
