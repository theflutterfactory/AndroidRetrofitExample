package com.protege.androiduserexample.api;

import com.protege.androiduserexample.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointInterface {

    @GET("users")
    Call<List<User>> getUser();
}
