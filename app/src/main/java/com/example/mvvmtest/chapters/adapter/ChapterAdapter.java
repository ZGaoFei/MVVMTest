package com.example.mvvmtest.chapters.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmtest.R;
import com.example.mvvmtest.chapters.model.ChaptersModel;

import java.util.List;


public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterHolder> {
    private Context context;

    private ChaptersModel model;

    public ChapterAdapter(Context context) {
        this.context = context;
    }

    public void update(ChaptersModel model) {
        this.model = model;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chapter, parent, false);
        return new ChapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterHolder holder, int position) {
        if (model != null && model.getData() != null) {
            List<ChaptersModel.Data> data = model.getData();
            if (data != null) {
                holder.tvName.setText(data.get(position).getName());
            }
        }
    }

    @Override
    public int getItemCount() {
        return model == null || model.getData() == null ? 0 : model.getData().size();
    }

    static class ChapterHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public ChapterHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_chapter_name);
        }
    }
}
