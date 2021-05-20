package com.example.mvvmtest.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmtest.R;
import com.example.mvvmtest.web.WebViewActivity;

import java.util.List;

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.BlogViewHolder> {

    private Context context;
    private List<BlogListModel.Data.ItemData> listModels;

    public BlogListAdapter(Context context) {
        this.context = context;
    }

    public void update(List<BlogListModel.Data.ItemData> list) {
        this.listModels = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_blog, parent, false);
        return new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        BlogListModel.Data.ItemData itemData = listModels.get(position);
        holder.tvTitle.setText(itemData.getTitle());
        holder.tvName.setText(itemData.getAuthor());
        List<BlogListModel.Data.ItemData.TagsDTO> tags = itemData.getTags();
        String tagStr = "";
        for (int i = 0; i < tags.size(); i++) {
            tagStr = "# " + tags.get(i).getName() + " ";
        }
        holder.tvTag.setText(tagStr);

        String link = itemData.getLink();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.start(context, link);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModels == null ? 0 : listModels.size();
    }

    static class BlogViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvName;
        private TextView tvTag;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_blog_title);
            tvName = itemView.findViewById(R.id.tv_blog_name);
            tvTag = itemView.findViewById(R.id.tv_blog_tag);
        }
    }
}
