package com.example.happytails.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytails.R;

import java.util.List;

import lombok.Setter;

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.TabViewHolder> {

    private final List<String> tabsText;
    @Setter private View.OnClickListener onTabClickListener;

    public TabAdapter(List<String> tabsText) {
        this.tabsText = tabsText;
    }

    @NonNull
    @Override
    public TabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tab, parent, false);
        return new TabViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TabViewHolder holder, int position) {
        String tabText = tabsText.get(position);

        holder.bind(tabText);
        holder.tabBtn.setOnClickListener(onTabClickListener);
    }

    @Override
    public int getItemCount() {
        return tabsText.size();
    }

    public static class TabViewHolder extends RecyclerView.ViewHolder {

        Button tabBtn;

        public TabViewHolder(@NonNull View itemView) {
            super(itemView);
            
            tabBtn      = itemView.findViewById(R.id.tabBtn);
        }

        public void bind(String text) {
            tabBtn.setText(text);
        }
    }
}
