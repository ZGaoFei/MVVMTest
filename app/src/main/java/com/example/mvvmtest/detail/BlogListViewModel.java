package com.example.mvvmtest.detail;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baselibrary.utils.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogListViewModel extends ViewModel {
    private final MediatorLiveData<BlogListModel> liveData = new MediatorLiveData<>();

    public LiveData<BlogListModel> getBlogList(int id, int page) {
        String url = "wxarticle/list/" + id + "/" + page + "/json";
        Call<BlogListModel> call = RetrofitManager.getRetrofit().create(BlogListInter.class).getBlog(url, "java", id, page);
        call.enqueue(new Callback<BlogListModel>() {
            @Override
            public void onResponse(Call<BlogListModel> call, Response<BlogListModel> response) {
                BlogListModel body = response.body();
                liveData.setValue(body);
            }

            @Override
            public void onFailure(Call<BlogListModel> call, Throwable t) {

            }
        });
        return liveData;
    }
}
