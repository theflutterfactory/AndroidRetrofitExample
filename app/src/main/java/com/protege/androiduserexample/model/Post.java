package com.protege.androiduserexample.model;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id")
    private String id;

    @SerializedName("body")
    private String body;

    @SerializedName("title")
    private String title;

    @SerializedName("userId")
    private String userId;

    public String getId () {
        return id;
    }

    public String getBody () {
        return body;
    }

    public String getTitle () {
        return title;
    }
}