package com.example.mvvmtest.chapters.net;

import com.example.mvvmtest.chapters.model.ChaptersModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Chapters {

    @GET("wxarticle/chapters/json")
    Call<ChaptersModel> getChapters();
}
