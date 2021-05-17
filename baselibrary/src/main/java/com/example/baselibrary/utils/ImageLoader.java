package com.example.baselibrary.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 这里不直接使用Glide，而是使用imageLoader进行简单的一层封装
 * 避免以后换库的时候，修改的地方过多
 *
 * 后面有用到新的方法，在下面直接添加
 */
public class ImageLoader {

    private ImageLoader() {

    }

    public static void displayImage(ImageView imageView, String url) {
        Glide.with(imageView)
                .load(url)
                .into(imageView);
    }

    public static void displayDefaultImage(ImageView imageView, String url) {
        Glide.with(imageView)
                .load(url)
                .placeholder(android.R.mipmap.sym_def_app_icon)
                .into(imageView);
    }
}
