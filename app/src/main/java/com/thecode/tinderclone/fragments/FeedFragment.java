package com.thecode.tinderclone.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thecode.tinderclone.R;
import com.thecode.tinderclone.activities.MainActivity;
import com.thecode.tinderclone.adapters.MatchListAdapter;
import com.thecode.tinderclone.entities.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    View rootLayout;
    private static final String TAG = MainActivity.class.getSimpleName();
    private List<Match> matchList;
    private MatchListAdapter mAdapter;
    private String[] matchDates = {"11 Jan. 2020", "26 Dec. 2019", "12 Dec. 2019", "17 Nov. 2019", "06 Oct. 2019"};
    private int[] matchPictures = {R.drawable.user_woman_3, R.drawable.user_woman_4, R.drawable.user_woman_5, R.drawable.user_woman_6 , R.drawable.user_woman_7};
    private String[] matchNames = {"Fanelle", "Chloe", "Cynthia", "Kate", "Angele"};
    private String[] matchLocations = {"à 3 km", "à 18 km", "à moins d'un kilometre", "à 4 km", "à 6 km"};


    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootLayout = inflater.inflate(R.layout.fragment_feed, container, false);


        RecyclerView recyclerView = rootLayout.findViewById(R.id.recycler_view_matchs);
        matchList = new ArrayList<>();
        mAdapter = new MatchListAdapter(getContext(), matchList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareMatchList();
        
        return rootLayout;
    }


    private void prepareMatchList(){

        Random rand = new Random();
        int id = rand.nextInt(100);
        int i;
        for(i=0; i<5; i++) {
            Match match = new Match(id, matchNames[i], matchPictures[i], matchLocations[i], matchDates[i]);
            matchList.add(match);
        }
    }


}
