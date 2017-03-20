package com.coco.texttablelayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private List<String> mTitleText;
    private ViewPager mViewPager;
    private List<String> mPagerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initEvent();
    }

    private void initEvent() {
        mPagerAdapter adapter = new mPagerAdapter();
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initData() {
        mTitleText = new ArrayList<>();
        mPagerText = new ArrayList<>();
        mTabLayout = (TabLayout) findViewById(R.id.indicator_title);
        mViewPager = (ViewPager) findViewById(R.id.indicator_pager);
        for (int i = 0; i < 20; i++) {
            mTitleText.add("title" + i);
            mPagerText.add("title" + i);
        }
    }

    private class mPagerAdapter extends PagerAdapter {
        @Override
        public CharSequence getPageTitle(int position) {
            return mPagerText.get(position);
        }

        @Override
        public int getCount() {
            return mTitleText.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(MainActivity.this);
            tv.setText(mTitleText.get(position));
            tv.setTextSize(25);
            container.addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    };

}
