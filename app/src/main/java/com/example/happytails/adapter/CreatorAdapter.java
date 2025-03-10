package com.example.happytails.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytails.R;
import com.example.happytails.listener.OnItemClickListener;
import com.example.happytails.data.model.User;

import java.util.List;

import lombok.Setter;

public class CreatorAdapter extends RecyclerView.Adapter<CreatorAdapter.CreatorViewHolder> {

    private final List<User> creators;
    @Setter
    private OnItemClickListener onItemClickListener;

    public CreatorAdapter(List<User> creators) {
        this.creators = creators;
    }

    @NonNull
    @Override
    public CreatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_creator, parent, false);
        return new CreatorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CreatorViewHolder holder, int position) {
        User creator = creators.get(position);

        holder.bind(creator);
        holder.creatorLayout.setOnClickListener(v -> {
            if (onItemClickListener != null)
                onItemClickListener.onItemClick(v, creator);
        });
    }

    @Override
    public int getItemCount() {
        return creators.size();
    }

    public static class CreatorViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout creatorLayout;
        ImageView creatorPFP;
        TextView creatorName;

        public CreatorViewHolder(@NonNull View itemView) {
            super(itemView);

            creatorLayout   = itemView.findViewById(R.id.creatorLayout);
            creatorPFP      = itemView.findViewById(R.id.creatorPFP);
            creatorName     = itemView.findViewById(R.id.creatorName);
        }

        public void bind(User creator) {
            creatorPFP.setImageIcon(creator.getPfp());
            creatorName.setText(creator.getName());
        }
    }
}
