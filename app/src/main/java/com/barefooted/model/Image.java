package com.barefooted.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }
}
