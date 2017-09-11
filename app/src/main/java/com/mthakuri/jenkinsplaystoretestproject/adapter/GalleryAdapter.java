package com.mthakuri.jenkinsplaystoretestproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mthakuri.jenkinsplaystoretestproject.R;
import com.mthakuri.jenkinsplaystoretestproject.model.PictureModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by mthakuri on 9/11/2017.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private ArrayList<PictureModel> pictures;

    public GalleryAdapter() {
        pictures = new ArrayList<>();
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GalleryViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gallery_adapater, parent, false));
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        PictureModel picture = pictures.get(position);
        Picasso.with(holder.imageView.getContext()).load(picture.getUrls().getThumb()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        GalleryViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.iv_pic);
        }
    }


    public void addAll(ArrayList<PictureModel> pictures) {
        this.pictures = pictures;
    }

}
