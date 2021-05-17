package com.example.baselibrary.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static final String BASE_URL = "https://wanandroid.com/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build();

    private RetrofitManager() {
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
