package com.example.happytails.login;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import androidx.lifecycle.viewmodel.CreationExtras;

import com.example.happytails.data.source.DataSourceFactory;
import com.example.happytails.data.source.LoginDataSource;
import com.example.happytails.data.repository.LoginRepository;


public class LoginViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass, @NonNull CreationExtras creationExtras) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            Application application = (Application) creationExtras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
            if (application == null) {
                throw new IllegalStateException("Application is null in CreationExtras");
            }

            Context context = application.getApplicationContext();
            LoginDataSource dataSource = DataSourceFactory.create(LoginDataSource.class, context);
            return (T) new LoginViewModel(LoginRepository.getInstance(dataSource));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}