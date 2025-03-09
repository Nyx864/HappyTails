package com.example.happytails.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytails.R;
import com.example.happytails.data.model.Article;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private final List<Article> articles;

    public ArticleAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article, parent,false);
        return new ArticleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article event = articles.get(position);
        holder.bind(event);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        ImageView ArticlePreview;
        TextView ArticleName;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            ArticlePreview        = itemView.findViewById(R.id.ArticlePreview);
            ArticleName           = itemView.findViewById(R.id.ArticleName);
        }

        public void bind(Article event) {
            if (event.getImage() != null) ArticlePreview.setImageIcon(event.getImage());
            ArticleName.setText(event.getName());
        }
    }
}
