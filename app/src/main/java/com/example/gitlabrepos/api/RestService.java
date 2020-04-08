package com.example.gitlabrepos.api;

import com.example.gitlabrepos.model.RepositoriesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/* Created by harishrevuri on 2020-04-08 */
public interface RestService {
    @GET("/api/v4/projects")
    Call<List<RepositoriesModel>> getRepos();
}
