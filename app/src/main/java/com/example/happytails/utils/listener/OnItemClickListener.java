package com.example.happytails.utils.listener;

import android.view.View;

@FunctionalInterface
public interface OnItemClickListener {
    void onItemClick(View view, Object data);
}
