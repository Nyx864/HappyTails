package com.example.happytails.utils.listener;

import android.view.View;

@FunctionalInterface
    public interface OnChosenStateUpdateListener {
        void onChosenStateUpdate(View v, boolean chosen);
    }