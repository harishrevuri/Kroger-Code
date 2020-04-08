package com.example.gitlabrepos.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* Created by harishrevuri on 2020-04-08 */
public class RestClient {
    private static final String BASE_URL = "https://gitlab.com";
    public static Retrofit retrofit = new Retrofit.Builder().
            baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
}
