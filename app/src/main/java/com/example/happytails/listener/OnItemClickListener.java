package com.example.happytails.listener;

import android.view.View;

@FunctionalInterface
public interface OnItemClickListener {
    public void onItemClick(View view, Object data);
}
