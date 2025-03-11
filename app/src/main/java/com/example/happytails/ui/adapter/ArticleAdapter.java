package com.example.happytails.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytails.R;
import com.example.happytails.utils.listener.OnItemClickListener;
import com.example.happytails.data.dto.Article;

import java.util.List;

import lombok.Setter;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private final List<Article> articles;
    @Setter private OnItemClickListener onItemClickListener;

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
        Article article = articles.get(position);

        holder.bind(article);
        holder.ArticlePreview.setOnClickListener(v -> {
            if (onItemClickListener != null)
                onItemClickListener.onItemClick(v, article);
        });
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

        public void bind(Article article) {
            if (article.getImage() != null) ArticlePreview.setImageIcon(article.getImage());
            ArticleName.setText(article.getName());
        }
    }
}
