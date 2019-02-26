package com.example.magicpinfeed.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.example.magicpinfeed.R;
import com.example.magicpinfeed.models.Feed;

public class VideoPlayerViewHolder extends RecyclerView.ViewHolder {

    public FrameLayout media_container;
    public TextView title;
    public ImageView thumbnail;
    public ProgressBar progressBar;
    public View parent;
    public RequestManager requestManager;

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        media_container = itemView.findViewById(R.id.media_container);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        title = itemView.findViewById(R.id.title);
        progressBar = itemView.findViewById(R.id.progressBar);
    }

    public void onBind(Feed feed, RequestManager requestManager) {
        this.requestManager = requestManager;
        parent.setTag(this);
        title.setText(feed.getTitle());
        this.requestManager
                .load(feed.getThumbnail())
                .into(thumbnail);
    }

}