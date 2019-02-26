package com.example.magicpinfeed.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.example.magicpinfeed.R;
import com.example.magicpinfeed.models.Feed;
import com.example.magicpinfeed.viewholder.VideoPlayerViewHolder;

import java.util.ArrayList;

public class VideoPlayerRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Feed> feedArrayList;
    private RequestManager requestManager;


    public VideoPlayerRecyclerAdapter(ArrayList<Feed> feedArrayList, RequestManager requestManager) {
        this.feedArrayList = feedArrayList;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VideoPlayerViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_item_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((VideoPlayerViewHolder)viewHolder).onBind(feedArrayList.get(i), requestManager);
    }

    @Override
    public int getItemCount() {
        return feedArrayList.size();
    }

}
