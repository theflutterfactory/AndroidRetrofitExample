package com.protege.androiduserexample.model;

import com.google.gson.annotations.SerializedName;

public class Geo {
    @SerializedName("lng")
    private String lng;

    @SerializedName("lat")
    private String lat;

    public String getLng () {
        return lng;
    }

    public String getLat () {
        return lat;
    }
}