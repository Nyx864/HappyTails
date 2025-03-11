package com.example.happytails.ui.adapter;

import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
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
import com.example.happytails.data.dto.User;
import com.example.happytails.utils.listener.OnItemClickListener;
import com.example.happytails.data.dto.Post;

import java.util.Iterator;
import java.util.List;

import lombok.Setter;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private final List<Post> posts;
    @Setter private OnItemClickListener onCreatorsClickListener;
    @Setter private OnItemClickListener onLikeClickListener;
    @Setter private OnItemClickListener onCommentClickListener;
    @Setter private OnItemClickListener onShareClickListener;

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

        holder.creatorsContainer.setOnClickListener(v -> {
            if (onCreatorsClickListener != null)
                onCreatorsClickListener.onItemClick(v, post);
        });

        holder.likeButton.setOnClickListener(v -> {
            if (onLikeClickListener != null)
                onLikeClickListener.onItemClick(v, post);
        });

        holder.commentButton.setOnClickListener(v -> {
            if (onCommentClickListener != null)
                onCommentClickListener.onItemClick(v, post);
        });

        holder.shareButton.setOnClickListener(v -> {
            if (onShareClickListener != null)
                onShareClickListener.onItemClick(v, post);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        private static final int MAX_CREATOR_TEXT_LENGTH = 25;

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
        TextView descriptionText;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            creatorsContainer = itemView.findViewById(R.id.creatorsContainer);
            likeButton = itemView.findViewById(R.id.likeButton);
            commentButton = itemView.findViewById(R.id.commentButton);
            shareButton = itemView.findViewById(R.id.shareButton);
            mainCreator = itemView.findViewById(R.id.mainCreator);
            secondCreator = itemView.findViewById(R.id.secondCreator);
            thirdCreator = itemView.findViewById(R.id.thirdCreator);
            contentImage = itemView.findViewById(R.id.contentImage);
            moreActions = itemView.findViewById(R.id.moreActions);
            likeText = itemView.findViewById(R.id.likeText);
            commentText = itemView.findViewById(R.id.commentText);
            shareText = itemView.findViewById(R.id.shareText);
            creatorText = itemView.findViewById(R.id.creatorText);
            descriptionText = itemView.findViewById(R.id.descriptionText);
        }

        public void bind(Post post) {
            setupCreators(post);
            setupContent(post);
            setupButtons(post);
        }

        private void setupCreators(Post post) {
            int creatorsCount = post.getCreators().size();

            if (creatorsCount > 0) {
                mainCreator.setImageIcon(post.getCreators().get(0).getPfp());
            }
            if (creatorsCount > 1) {
                secondCreator.setImageIcon(post.getCreators().get(1).getPfp());
            }
            if (creatorsCount > 2) {
                thirdCreator.setImageIcon(post.getCreators().get(2).getPfp());
            }

            creatorText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(MAX_CREATOR_TEXT_LENGTH)});
            String creatorNames = getCreatorsNamesAsString(post);
            creatorText.setText(creatorNames);
        }

        private void setupContent(Post post) {
            contentImage.setImageIcon(post.getContentIcon());

            String username = post.getCreators().get(0).getName();
            String fullText = username + " " + post.getDescription();
            SpannableString spannableString = new SpannableString(fullText);
            spannableString.setSpan(
                    new StyleSpan(Typeface.BOLD),
                    0,
                    username.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            );
            descriptionText.setText(spannableString);
        }

        private void setupButtons(Post post) {
            likeText.setText(String.valueOf(post.getLikes().size()));
            commentText.setText(String.valueOf(post.getComments().size()));
            shareText.setText(String.valueOf(post.getShares().size()));
        }

        private String getCreatorsNamesAsString(Post post) {
            StringBuilder res = new StringBuilder();

            Iterator<User> user = post.getCreators().iterator();
            while (res.length() < MAX_CREATOR_TEXT_LENGTH
                    && user.hasNext()) {
                res.append(", ").append(user.next().getName());
            }

            return res.delete(0, 2).toString(); // delete ", " before names
        }
    }
}
