package com.example.germanpereyra.retrofit_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        // Create a very simple REST adapter which points the GitHub API endpoint.
        GitHubClient client =  retrofit.create(GitHubClient.class);

        // Fetch a list of the Github repositories.
        Call<List<GitHubRepo>> call =
                client.reposForUser("P0nj4");

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                if (response.isSuccessful()) {

                    for (GitHubRepo repo : response.body()) {
                        Log.d("TESTING", repo.getName());

                    }
                }

            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });

    }
}
