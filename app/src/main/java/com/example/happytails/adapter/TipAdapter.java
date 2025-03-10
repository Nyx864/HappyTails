package com.example.happytails.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytails.R;
import com.example.happytails.listener.OnItemClickListener;
import com.example.happytails.data.model.Article;

import java.util.List;

import lombok.Setter;

public class TipAdapter extends RecyclerView.Adapter<TipAdapter.TipViewHolder> {

    private final List<Article> tips;
    @Setter private OnItemClickListener onItemClickListener;

    public TipAdapter(List<Article> tips) {
        this.tips = tips;
    }

    @NonNull
    @Override
    public TipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tip, parent,false);
        return new TipViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TipViewHolder holder, int position) {
        Article tip = tips.get(position);

        holder.bind(tip);
        holder.tipReadBtn.setOnClickListener(v -> {
            if (onItemClickListener != null)
                onItemClickListener.onItemClick(v, tip);
        });
    }

    @Override
    public int getItemCount() {
        return tips.size();
    }

    public static class TipViewHolder extends RecyclerView.ViewHolder {

        ImageView tipImage;
        TextView tipText;
        TextView tipGroup;
        Button tipReadBtn;

        public TipViewHolder(@NonNull View itemView) {
            super(itemView);

            tipImage        = itemView.findViewById(R.id.tipImage);
            tipText         = itemView.findViewById(R.id.tipText);
            tipGroup        = itemView.findViewById(R.id.tipGroup);
            tipReadBtn      = itemView.findViewById(R.id.tipReadBtn);
        }

        public void bind(Article tip) {
            tipImage.setImageIcon(tip.getImage());
            tipText.setText(tip.getName());
            tipGroup.setText(tip.getGroupName());
        }
    }
}
