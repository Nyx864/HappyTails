package com.example.happytails.data.source;

import android.content.Context;

import androidx.annotation.NonNull;

public class DataSourceFactory {

    @NonNull
    @SuppressWarnings("unchecked")
    public static <T extends BaseDataSource> T create(@NonNull Class<T> modelClass, @NonNull Context context) {
        if (modelClass.isAssignableFrom(LoginDataSource.class)) {
            return (T) new LoginDataSource(context);
        } else {
            throw new IllegalArgumentException("Unknown DataSource class");
        }
    }
}
