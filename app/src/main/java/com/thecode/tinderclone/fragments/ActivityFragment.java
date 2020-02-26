package com.thecode.tinderclone.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.thecode.tinderclone.R;
import com.thecode.tinderclone.adapters.ViewPagerAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityFragment extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {


    private Context mContext;
    private ViewPager viewPager;
    private View rootLayout;
    private TextView chatText, feedText;
    private LinearLayout chatLayout, feedLayout;

    public ActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootLayout = inflater.inflate(R.layout.fragment_activity, container, false);
        mContext = getContext();
        chatLayout = rootLayout.findViewById(R.id.layout_chat);
        feedLayout = rootLayout.findViewById(R.id.layout_feed);
        chatText = rootLayout.findViewById(R.id.text_chat);
        feedText = rootLayout.findViewById(R.id.text_feed);

        ArrayList<Fragment> fragList = new ArrayList<>();
        fragList.add(new ChatFragment());
        fragList.add(new FeedFragment());
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(fragList, getActivity().getSupportFragmentManager());
        viewPager = rootLayout.findViewById(R.id.view_pager_frag);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(this);
        chatLayout.setOnClickListener(this);
        feedLayout.setOnClickListener(this);

        return rootLayout;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_chat:
                viewPager.setCurrentItem(0);
                chatText.setTextColor(getResources().getColor(R.color.colorPrimary));
                feedText.setTextColor(getResources().getColor(R.color.light_gray));
                break;
            case R.id.layout_feed:
                viewPager.setCurrentItem(1);
                chatText.setTextColor(getResources().getColor(R.color.light_gray));
                feedText.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                chatText.setTextColor(getResources().getColor(R.color.colorPrimary));
                feedText.setTextColor(getResources().getColor(R.color.light_gray));
                break;
            case 1:
                chatText.setTextColor(getResources().getColor(R.color.light_gray));
                feedText.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
