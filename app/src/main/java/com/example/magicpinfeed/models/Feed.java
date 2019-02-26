package com.example.magicpinfeed.models;

public class Feed {

    private  String title, thumbnail, video_url;

    public Feed(){}

    public Feed(String title, String thumbnail, String video_url) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.video_url = video_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
}
