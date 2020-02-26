package com.thecode.tinderclone.fragments;


import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.thecode.tinderclone.R;
import com.thecode.tinderclone.Utils;
import com.thecode.tinderclone.entities.Profile;
import com.thecode.tinderclone.entities.TinderCard;

/**
 * A simple {@link Fragment} subclass.
 */
public class SwipeViewFragment extends Fragment {


    private View rootLayout;
    private FloatingActionButton fabBack, fabLike, fabSkip, fabSuperLike, fabBoost;

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    public SwipeViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootLayout = inflater.inflate(R.layout.fragment_swipe_view, container, false);

        return rootLayout;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSwipeView = view.findViewById(R.id.swipeView);
        fabBack = view.findViewById(R.id.fabBack);
        fabLike = view.findViewById(R.id.fabLike);
        fabSkip = view.findViewById(R.id.fabSkip);
        fabSuperLike = view.findViewById(R.id.fabSuperLike);
        fabBoost = view.findViewById(R.id.fabBoost);


        mContext = getActivity();

        int bottomMargin = Utils.dpToPx(100);
        Point windowSize = Utils.getDisplaySize(getActivity().getWindowManager());
        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setViewWidth(windowSize.x)
                        .setViewHeight(windowSize.y - bottomMargin)
                        .setViewGravity(Gravity.TOP)
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));


        for(Profile profile : Utils.loadProfiles(getActivity())){
            mSwipeView.addView(new TinderCard(mContext, profile, mSwipeView));
        }

        fabSkip.setOnClickListener(v -> {
            animateFab(fabSkip);
            mSwipeView.doSwipe(false);
        });

        fabLike.setOnClickListener(v -> {
            animateFab(fabLike);
            mSwipeView.doSwipe(true);
        });

        fabBoost.setOnClickListener(v -> animateFab(fabBoost));
        fabSuperLike.setOnClickListener(v -> animateFab(fabSuperLike));
        fabBack.setOnClickListener(v -> animateFab(fabBack));
    }


    private void animateFab(final FloatingActionButton fab){
        fab.animate().scaleX(0.7f).setDuration(100).withEndAction(() -> fab.animate().scaleX(1f).scaleY(1f));
    }

}
