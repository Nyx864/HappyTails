package com.example.happytails.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytails.R;
import com.example.happytails.data.dto.Comment;
import com.example.happytails.utils.listener.OnItemClickListener;

import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.Setter;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder>{

    private final List<Comment> comments;
    @Setter OnItemClickListener onItemClickListener;

    public CommentAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent,false);
        return new CommentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = comments.get(position);

        holder.commentLikeBtn.setOnClickListener(v -> {
            if (onItemClickListener != null)
                onItemClickListener.onItemClick(v, comment);
        });

        holder.bind(comment);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public static class CommentViewHolder extends RecyclerView.ViewHolder {

        ImageFilterView commentCreatorImage;
        TextView commentReputationText;
        TextView commentCreatorName;
        TextView commentContent;
        TextView commentDate;
        ImageButton commentLikeBtn;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            commentCreatorImage     = itemView.findViewById(R.id.commentCreatorImage);
            commentReputationText   = itemView.findViewById(R.id.commentReputationText);
            commentCreatorName      = itemView.findViewById(R.id.commentCreatorName);
            commentContent          = itemView.findViewById(R.id.commentContent);
            commentDate             = itemView.findViewById(R.id.commentDate);
            commentLikeBtn          = itemView.findViewById(R.id.commentLikeBtn);
        }

        public void bind(Comment comment) {
            commentCreatorImage.setImageIcon(comment.getUser().getPfp());
            commentReputationText.setText(String.valueOf(comment.getReputation()));
            commentCreatorName.setText(comment.getUser().getName());
            commentContent.setText(comment.getText());
            commentDate.setText(comment.getSendTime().format(DateTimeFormatter.ISO_LOCAL_TIME));
        }
    }
}
