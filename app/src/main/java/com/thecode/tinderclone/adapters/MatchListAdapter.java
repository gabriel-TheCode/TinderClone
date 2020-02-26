package com.thecode.tinderclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.thecode.tinderclone.R;
import com.thecode.tinderclone.entities.Match;

import java.util.List;

public class MatchListAdapter extends RecyclerView.Adapter<MatchListAdapter.MyViewHolder> {
    private Context context;
    private List<Match> matchList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, date, location;
        ImageView imgProfile, imgContent;

        MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.text_name);
            date = view.findViewById(R.id.text_date);
            location = view.findViewById(R.id.text_location);
            imgProfile = view.findViewById(R.id.img_profile);
            imgContent = view.findViewById(R.id.img_content);

        }
    }


    public MatchListAdapter(Context context, List<Match> matchList) {
        this.context = context;
        this.matchList = matchList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_layout_match, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Match item = matchList.get(position);
        holder.name.setText(item.getName());
        holder.date.setText(item.getDate());
        holder.location.setText(item.getLocation());

        Glide.with(context)
                .load(item.getPicture())
                .into(holder.imgProfile);

        Glide.with(context)
                .load(item.getPicture())
                .into(holder.imgContent);
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

}