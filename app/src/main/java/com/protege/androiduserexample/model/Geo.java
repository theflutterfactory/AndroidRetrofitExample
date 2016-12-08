package com.protege.androiduserexample.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Geo {
    @SerializedName("lng")
    private String lng;

    @SerializedName("lat")
    private String lat;
}