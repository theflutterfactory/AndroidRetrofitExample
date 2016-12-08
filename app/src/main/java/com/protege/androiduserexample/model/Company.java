package com.protege.androiduserexample.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Company {
    @SerializedName("catchPhrase")
    private String catchPhrase;

    @SerializedName("name")
    private String name;

    @SerializedName("bs")
    private String bs;

    public String getName () {
        return name;
    }

}