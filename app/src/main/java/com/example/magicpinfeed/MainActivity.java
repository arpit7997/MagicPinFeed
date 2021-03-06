package com.example.magicpinfeed;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MotionEvent;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.magicpinfeed.adapter.VideoPlayerRecyclerAdapter;
import com.example.magicpinfeed.models.Feed;
import com.example.magicpinfeed.utils.CommonMethods;
import com.example.magicpinfeed.utils.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Feed> feedArrayList = new ArrayList<>();

    private VideoPlayerRecyclerView mRecyclerView;
    ConstraintLayout constraint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        constraint = findViewById(R.id.constraint);

        initFeedArrayList();

        initRecyclerView();

        Toast.makeText(this, "Scroll to play video feed", Toast.LENGTH_LONG).show();

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

        feedArrayList.add(new Feed("How's the Josh at Magic Pin? ", "https://firebasestorage.googleapis.com/v0/b/urban-clap-copy.appspot.com/o/IMG_20190304_155617.jpg?alt=media&token=cc416e05-3ce9-4bab-ae21-25a1be8bedad", "https://player.vimeo.com/external/286837529.m3u8?s=20f83af6ea8fbfc8ce0c2001f32bf037f8b0f65f"));
        feedArrayList.add(new Feed("Introduction to  Magic Pin", "https://firebasestorage.googleapis.com/v0/b/urban-clap-copy.appspot.com/o/IMG_20190304_155604.jpg?alt=media&token=da823bda-3ab1-40e7-83ba-4412c222e022", "https://player.vimeo.com/external/286837767.m3u8?s=42570e8c4a91b98cdec7e7bfdf0eccf54e700b69"));
        feedArrayList.add(new Feed("Why choose Magic Pin", "https://firebasestorage.googleapis.com/v0/b/urban-clap-copy.appspot.com/o/IMG_20190304_155524.jpg?alt=media&token=cfcaa22f-9313-4590-af23-537ad126784f", "https://player.vimeo.com/external/286837810.m3u8?s=610b4fee49a71c2dbf22c01752372ff1c6459b9e"));
        feedArrayList.add(new Feed("Meet the Team", "https://firebasestorage.googleapis.com/v0/b/urban-clap-copy.appspot.com/o/IMG_20190304_155524.jpg?alt=media&token=cfcaa22f-9313-4590-af23-537ad126784f", "https://player.vimeo.com/external/286837723.m3u8?s=3df60d3c1c6c7a11df4047af99c5e05cc2e7ae96"));
        feedArrayList.add(new Feed("Featured in Hindustan Times", "https://firebasestorage.googleapis.com/v0/b/urban-clap-copy.appspot.com/o/IMG_20190304_155509.jpg?alt=media&token=7f1343cc-077e-494e-b050-2cb2afe21f35", "https://player.vimeo.com/external/286837649.m3u8?s=9e486e9b932be72a8875afc6eaae21bab124a35a"));
        feedArrayList.add(new Feed("Last Video", "https://firebasestorage.googleapis.com/v0/b/urban-clap-copy.appspot.com/o/IMG_20190304_155630.jpg?alt=media&token=56a88443-f6c9-43ed-9f2a-28820f2924d7", "https://player.vimeo.com/external/286837402.m3u8?s=7e01c398e2f01c29ecbd46e5e2dd53e0d6c1905d"));
    }
}
