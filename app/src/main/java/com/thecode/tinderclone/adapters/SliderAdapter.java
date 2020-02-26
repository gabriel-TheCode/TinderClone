package com.thecode.tinderclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.thecode.tinderclone.R;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout_slider, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {

        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.bolt)
                        .into(viewHolder.imageViewSlider);
                viewHolder.textViewTitle.setText(context.getResources().getString(R.string.title_slider_1));
                viewHolder.textViewDescription.setText(context.getResources().getString(R.string.description_slider_1));
                break;
            case 1:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.ic_like_24dp)
                        .into(viewHolder.imageViewSlider);
                viewHolder.textViewTitle.setText(context.getResources().getString(R.string.title_slider_2));
                viewHolder.textViewDescription.setText(context.getResources().getString(R.string.description_slider_2));
                break;
            case 2:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.ic_location_on_blue_24dp)
                        .into(viewHolder.imageViewSlider);
                viewHolder.textViewTitle.setText(context.getResources().getString(R.string.title_slider_3));
                viewHolder.textViewDescription.setText(context.getResources().getString(R.string.description_slider_3));
                break;

            case 3:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.ic_star_blue_24dp)
                        .into(viewHolder.imageViewSlider);
                viewHolder.textViewTitle.setText(context.getResources().getString(R.string.title_slider_4));
                viewHolder.textViewDescription.setText(context.getResources().getString(R.string.description_slider_4));
                break;

            case 4:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.reverse)
                        .into(viewHolder.imageViewSlider);
                viewHolder.textViewTitle.setText(context.getResources().getString(R.string.title_slider_5));
                viewHolder.textViewDescription.setText(context.getResources().getString(R.string.description_slider_5));
                break;

            case 5:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.ic_star_turquoise_24dp)
                        .into(viewHolder.imageViewSlider);
                viewHolder.textViewTitle.setText(context.getResources().getString(R.string.title_slider_6));
                viewHolder.textViewDescription.setText(context.getResources().getString(R.string.description_slider_6));
                break;
        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 6;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewSlider;
        TextView textViewDescription, textViewTitle;

        SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewSlider = itemView.findViewById(R.id.image_slider);
            textViewTitle = itemView.findViewById(R.id.text_slider_title);
            textViewDescription = itemView.findViewById(R.id.text_slider_description);
            this.itemView = itemView;
        }
    }
}