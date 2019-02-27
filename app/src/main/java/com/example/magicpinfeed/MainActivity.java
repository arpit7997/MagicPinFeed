package com.example.magicpinfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.magicpinfeed.adapter.VideoPlayerRecyclerAdapter;
import com.example.magicpinfeed.models.Feed;
import com.example.magicpinfeed.utils.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Feed> feedArrayList = new ArrayList<>();

    private VideoPlayerRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);

        initFeedArrayList();

        initRecyclerView();

    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(100);
        mRecyclerView.addItemDecoration(itemDecorator);

        mRecyclerView.setFeed(feedArrayList);
        VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(feedArrayList, initGlide());
        mRecyclerView.setAdapter(adapter);
    }

    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.magicpin)
                .error(R.drawable.magicpin);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }


    @Override
    protected void onDestroy() {
        if(mRecyclerView!=null)
            mRecyclerView.releasePlayer();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRecyclerView.videoPlayer.setPlayWhenReady(false);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mRecyclerView.videoPlayer.setPlayWhenReady(true);
    }

    private void initFeedArrayList() {

        feedArrayList.add(new Feed("Video 1", "", "https://player.vimeo.com/external/286837767.m3u8?s=42570e8c4a91b98cdec7e7bfdf0eccf54e700b69"));
        feedArrayList.add(new Feed("Video 2", "", "https://player.vimeo.com/external/286837810.m3u8?s=610b4fee49a71c2dbf22c01752372ff1c6459b9e"));
        feedArrayList.add(new Feed("Video 3", "", "https://player.vimeo.com/external/286837723.m3u8?s=3df60d3c1c6c7a11df4047af99c5e05cc2e7ae96"));
        feedArrayList.add(new Feed("Video 4", "", "https://player.vimeo.com/external/286837649.m3u8?s=9e486e9b932be72a8875afc6eaae21bab124a35a"));
        feedArrayList.add(new Feed("Video 5", "", "https://player.vimeo.com/external/286837529.m3u8?s=20f83af6ea8fbfc8ce0c2001f32bf037f8b0f65f"));
        feedArrayList.add(new Feed("Video 6", "", "https://player.vimeo.com/external/286837402.m3u8?s=7e01c398e2f01c29ecbd46e5e2dd53e0d6c1905d"));
    }
}
