package com.protege.androiduserexample.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private String id;

    @SerializedName("phone")
    private String phone;

    @SerializedName("username")
    private String username;

    @SerializedName("website")
    private String website;

    @SerializedName("address")
    private Address address;

    @SerializedName("email")
    private String email;

    @SerializedName("company")
    private Company company;

    @SerializedName("name")
    private String name;

    public String getId () {
        return id;
    }

    public String getPhone () {
        return phone;
    }

    public String getUsername () {
        return username;
    }

    public String getWebsite () {
        return website;
    }

    public Address getAddress () {
        return address;
    }

    public String getEmail () {
        return email;
    }

    public Company getCompany () {
        return company;
    }

    public String getName () {
        return name;
    }
}