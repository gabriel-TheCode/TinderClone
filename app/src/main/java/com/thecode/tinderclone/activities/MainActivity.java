package com.thecode.tinderclone.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.thecode.tinderclone.R;
import com.thecode.tinderclone.Utils;
import com.thecode.tinderclone.adapters.ViewPagerAdapter;
import com.thecode.tinderclone.entities.Profile;
import com.thecode.tinderclone.entities.TinderCard;
import com.thecode.tinderclone.fragments.AccountFragment;
import com.thecode.tinderclone.fragments.ActivityFragment;
import com.thecode.tinderclone.fragments.ChatFragment;
import com.thecode.tinderclone.fragments.FeedFragment;
import com.thecode.tinderclone.fragments.SwipeViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    private Context mContext;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        BottomNavigationView bnv = findViewById(R.id.bottom_navigation);

        ArrayList<Fragment> fragList = new ArrayList<>();
        fragList.add(new AccountFragment());
        fragList.add(new SwipeViewFragment());
        fragList.add(new ActivityFragment());
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(fragList, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        bnv.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.account:
                viewPager.setCurrentItem(0);
                break;
            case R.id.fire:
                viewPager.setCurrentItem(1);
                break;
            case R.id.chat:
                viewPager.setCurrentItem(2);
                break;
        }
        return true;
    }
}