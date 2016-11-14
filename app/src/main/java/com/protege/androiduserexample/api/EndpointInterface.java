package com.protege.androiduserexample.api;

import com.protege.androiduserexample.model.Post;
import com.protege.androiduserexample.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EndpointInterface {

    @GET("users")
    Call<List<User>> getUser();

    @GET("posts")
    Call<List<Post>> getUserPosts(@Query("userId") String userId);
}
