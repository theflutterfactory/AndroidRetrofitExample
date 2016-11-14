package com.protege.androiduserexample.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Address {
    @SerializedName("geo")
    private Geo geo;

    @SerializedName("zipcode")
    private String zipcode;

    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String suite;

    @SerializedName("city")
    private String city;

    public Geo getGeo() {
        return geo;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }
}