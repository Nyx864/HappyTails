package com.example.happytails.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytails.R;
import com.example.happytails.data.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> posts;

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);

        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout creatorsContainer;
        ImageButton likeButton;
        ImageButton commentButton;
        ImageButton shareButton;
        ImageView mainCreator;
        ImageView secondCreator;
        ImageView thirdCreator;
        ImageView contentImage;
        ImageView moreActions;
        TextView likeText;
        TextView commentText;
        TextView shareText;
        TextView creatorText;
        TextView creatorDescriptionText;
        TextView descriptionText;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            creatorsContainer       = itemView.findViewById(R.id.creatorsContainer);
            likeButton              = itemView.findViewById(R.id.likeButton);
            commentButton           = itemView.findViewById(R.id.commentButton);
            shareButton             = itemView.findViewById(R.id.shareButton);
            mainCreator             = itemView.findViewById(R.id.mainCreator);
            secondCreator           = itemView.findViewById(R.id.secondCreator);
            thirdCreator            = itemView.findViewById(R.id.thirdCreator);
            contentImage            = itemView.findViewById(R.id.contentImage);
            moreActions             = itemView.findViewById(R.id.moreActions);
            likeText                = itemView.findViewById(R.id.likeText);
            commentText             = itemView.findViewById(R.id.commentText);
            shareText               = itemView.findViewById(R.id.shareText);
            creatorText             = itemView.findViewById(R.id.creatorText);
            creatorDescriptionText  = itemView.findViewById(R.id.creatorDescriptionText);
            descriptionText         = itemView.findViewById(R.id.descriptionText);
        }

        public void bind(Post post) {
            contentImage.setImageIcon(post.getContentIcon());

            descriptionText.setText(post.getDescription());

            likeText.setText(String.valueOf(post.getLikes().size()));
            commentText.setText(String.valueOf(post.getComments().size()));
            shareText.setText(String.valueOf(post.getShares().size()));
        }
    }
}
