package com.example.happytails.data.source;

import android.content.Context;

import com.example.happytails.data.dto.RegisterData;
import com.example.happytails.data.dto.SingInData;
import com.example.happytails.utils.Result;
import com.example.happytails.data.dto.LoggedInUser;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class LoginDataSource implements BaseDataSource {

    private final LoginPreferenceStorage loginPreferenceStorage;

    public LoginDataSource(Context context) {
        this.loginPreferenceStorage = LoginPreferenceStorage.getInstance(context);
    }

    public CompletableFuture<LoggedInUser> singIn(SingInData singInData) {
        CompletableFuture<LoggedInUser> fakeUser = CompletableFuture.supplyAsync(() ->
                new LoggedInUser(UUID.randomUUID().toString(), "fakeUser"));

        fakeUser.thenAccept(res -> loginPreferenceStorage.saveLoginData(
                singInData.getUsernameOrEmail(),
                singInData.getPassword()));

        return fakeUser;
    }

    public CompletableFuture<LoggedInUser> register(RegisterData registerData) {
        CompletableFuture<LoggedInUser> fakeUser = CompletableFuture.supplyAsync(() ->
                new LoggedInUser(UUID.randomUUID().toString(), "fakeUser"));

        fakeUser.thenAccept(res -> loginPreferenceStorage.saveLoginData(
                registerData.getUsername(),
                registerData.getPassword()));

        return fakeUser;
    }

    public void logout() {
        loginPreferenceStorage.clearDataFromPreferences();
    }

    public CompletableFuture<LoggedInUser> getLoggedInUser() {
        Result<SingInData> result = loginPreferenceStorage.getSavedLoginData();
        if (result instanceof Result.Success) {
            SingInData data = ((Result.Success<SingInData>) result).getData();
            return singIn(data);
        } else {
            return CompletableFuture.completedFuture(null);
        }
    }
}