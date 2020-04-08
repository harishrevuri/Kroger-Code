package com.example.gitlabrepos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.gitlabrepos.adapter.DataAdapter;
import com.example.gitlabrepos.api.RestClient;
import com.example.gitlabrepos.api.RestService;
import com.example.gitlabrepos.model.RepositoriesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<RepositoriesModel> repositoriesModelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestService restService = RestClient.retrofit.create(RestService.class);
        Call<List<RepositoriesModel>> call = restService.getRepos();
        call.enqueue(new Callback<List<RepositoriesModel>>() {
            @Override
            public void onResponse(Call<List<RepositoriesModel>> call, Response<List<RepositoriesModel>> response) {
                 repositoriesModelsList = response.body();

            }

            @Override
            public void onFailure(Call<List<RepositoriesModel>> call, Throwable t) {
                t.getMessage();
            }
        });
    }
}