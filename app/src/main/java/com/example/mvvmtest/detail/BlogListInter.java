package com.example.mvvmtest.detail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface BlogListInter {

    @GET
    Call<BlogListModel> getBlog(@Url String url,  @Query("k") String k, @Query("id") int id, @Query("page") int page);
}
