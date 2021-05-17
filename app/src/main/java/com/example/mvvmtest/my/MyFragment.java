package com.example.mvvmtest.my;

import android.os.Bundle;

import android.view.View;

import com.example.baselibrary.base.BaseFragment;
import com.example.mvvmtest.R;

/**
 * 我的页面
 */
public class MyFragment extends BaseFragment {

    public MyFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View view) {

    }
}