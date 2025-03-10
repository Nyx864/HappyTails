package com.example.happytails.listener;

import android.view.View;

@FunctionalInterface
    public interface OnChosenStateUpdateListener {
        void onChosenStateUpdate(View v, boolean chosen);
    }