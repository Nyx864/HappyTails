package com.example.happytails.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.happytails.R;
import com.example.happytails.listener.OnChosenStateUpdateListener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.TabViewHolder> {

    private final List<String> tabsText;
    @Setter private OnChosenStateUpdateListener onStateUpdateListener;
    @Getter private Set<View> chosenTabs = new HashSet<>();

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
        holder.tabBtn.setOnClickListener(v -> {
            if(chosenTabs.contains(v)) {
                chosenTabs.remove(v);
                holder.setupUnchosen();
                notifyChosenStateUpdated(v, false);
            } else {
                chosenTabs.add(v);
                holder.setupChosen();
                notifyChosenStateUpdated(v, true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tabsText.size();
    }

    public void notifyChosenStateUpdated(View view, boolean chosen) {
        if (onStateUpdateListener != null)
            onStateUpdateListener.onChosenStateUpdate(view, chosen);
    }

    public static class TabViewHolder extends RecyclerView.ViewHolder {

        private final float DEFAULT_TEXT_SIZE;
        private final float INCREMENTED_TEXT_SIZE;
        private final Context context;

        Button tabBtn;
        View activeDemonstrator;


        public TabViewHolder(@NonNull View itemView) {
            super(itemView);

            tabBtn                  = itemView.findViewById(R.id.tabBtn);
            activeDemonstrator      = itemView.findViewById(R.id.activeDemonstrator);

            context = itemView.getContext();
            DEFAULT_TEXT_SIZE = tabBtn.getTextSize();
            INCREMENTED_TEXT_SIZE = tabBtn.getTextSize() * 1.1f;
        }

        public void bind(String text) {
            tabBtn.setText(text);
        }

        public void setupChosen() {
            Typeface typeface = ResourcesCompat.getFont(context, R.font.inter_bold);
            tabBtn.setTypeface(typeface);
            tabBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, INCREMENTED_TEXT_SIZE);
            activeDemonstrator.setVisibility(View.VISIBLE);
        }

        public void setupUnchosen() {
            Typeface typeface = ResourcesCompat.getFont(context, R.font.inter_medium);
            tabBtn.setTypeface(typeface);
            tabBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX, DEFAULT_TEXT_SIZE);
            activeDemonstrator.setVisibility(View.INVISIBLE);
        }
    }
}
