package com.example.mvvmtest.chapters;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baselibrary.base.BaseFragment;
import com.example.mvvmtest.R;
import com.example.mvvmtest.chapters.adapter.ChapterAdapter;
import com.example.mvvmtest.chapters.model.ChaptersModel;

/**
 * 公众号列表
 * https://wanandroid.com/wxarticle/chapters/json
 * <p>
 * 某个公众号历史数据
 * https://wanandroid.com/wxarticle/list/408/1/json?k=java&id=408&page=1
 */
public class ChaptersFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private ChapterAdapter adapter;

    public ChaptersFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        request();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_chapters;
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.chapters_recycle_view);
        adapter = new ChapterAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void request() {
        ChaptersViewModel viewModel = new ViewModelProvider.NewInstanceFactory().create(ChaptersViewModel.class);
        viewModel.requestChapters().observe(this, new Observer<ChaptersModel>() {
            @Override
            public void onChanged(ChaptersModel chaptersModel) {
                Log.e("zgf", "======onChanged=======" + chaptersModel.getErrorCode());
                Log.e("zgf", "======onChanged=======" + chaptersModel.getData());
                Log.e("zgf", "======onChanged=======" + chaptersModel.getData().size());
                Log.e("zgf", "======onChanged=======" + chaptersModel.getData().get(0).getName());
                adapter.update(chaptersModel);
            }
        });
    }

}