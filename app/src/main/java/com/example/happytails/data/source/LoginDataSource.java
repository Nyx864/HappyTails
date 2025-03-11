package com.example.happytails.data.source;

import android.content.Context;

import com.example.happytails.data.dto.LoginData;
import com.example.happytails.utils.Result;
import com.example.happytails.data.dto.LoggedInUser;

import java.io.IOException;

public class LoginDataSource implements BaseDataSource {

    private final LoginPreferenceStorage loginPreferenceStorage;

    public LoginDataSource(Context context) {
        this.loginPreferenceStorage = LoginPreferenceStorage.getInstance(context);
    }

    public Result<LoggedInUser> login(LoginData loginData) {

        try {
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "fakeUser");
            loginPreferenceStorage.saveLoginData(loginData);
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        loginPreferenceStorage.clearDataFromPreferences();
    }

    public Result<LoggedInUser> getLoggedInUser() {
        Result<LoginData> result = loginPreferenceStorage.getSavedLoginData();
        if (result instanceof Result.Success) {
            LoginData data = ((Result.Success<LoginData>) result).getData();
            return login(data);
        } else {
            return null;
        }
    }
}