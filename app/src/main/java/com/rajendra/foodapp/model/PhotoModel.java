package com.rajendra.foodapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PhotoModel implements Serializable {
    @SerializedName("title")
    String tvtitle;

    @SerializedName("url")
    String fullUrl;

    public String getTvtitle() {
        return tvtitle;
    }

    public void setTvtitle(String tvtitle) {
        this.tvtitle = tvtitle;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }
}