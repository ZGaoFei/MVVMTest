package com.example.mvvmtest.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baselibrary.base.BaseActivity;
import com.example.mvvmtest.R;


public class BlogListActivity extends BaseActivity {
    private BlogListAdapter adapter;

    private int id;

    public static void start(Context context, int id) {
        Intent intent = new Intent(context, BlogListActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_blog_list;
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.blog_list_recycler_view);
        adapter = new BlogListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        id = getIntent().getIntExtra("id", 0);
        new ViewModelProvider.NewInstanceFactory().create(BlogListViewModel.class).getBlogList(id, 1).observe(this, new Observer<BlogListModel>() {
            @Override
            public void onChanged(BlogListModel blogListModel) {
                adapter.update(blogListModel.getData().getItemData());
            }
        });
    }
}