package com.example.mvvmtest.chapters;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baselibrary.utils.RetrofitManager;
import com.example.mvvmtest.chapters.model.ChaptersModel;
import com.example.mvvmtest.chapters.net.Chapters;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChaptersViewModel extends ViewModel {
    private final MediatorLiveData<ChaptersModel> liveData = new MediatorLiveData<>();

    public LiveData<ChaptersModel> requestChapters() {
        Call<ChaptersModel> call = RetrofitManager.getRetrofit().create(Chapters.class).getChapters();
        call.enqueue(new Callback<ChaptersModel>() {
            @Override
            public void onResponse(Call<ChaptersModel> call, Response<ChaptersModel> response) {
                ChaptersModel body = response.body();
                liveData.setValue(body);
            }

            @Override
            public void onFailure(Call<ChaptersModel> call, Throwable t) {

            }
        });
        return liveData;
    }
}
