package com.example.germanpereyra.retrofit_sample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by germanpereyra on 6/30/17.
 */

public interface GitHubClient {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );
}
