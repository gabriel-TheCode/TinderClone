package com.thecode.tinderclone.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;


/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public ViewPagerAdapter(List<Fragment> fragmentList, FragmentManager fm) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        if(position >= 0 && position < fragmentList.size()) {
            return fragmentList.get(position);
        }

        return new Fragment();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}