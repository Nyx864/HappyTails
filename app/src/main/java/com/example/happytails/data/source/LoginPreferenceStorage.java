package com.example.happytails.data.source;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.happytails.data.dto.LoginData;
import com.example.happytails.utils.Result;

import java.io.IOException;

public class LoginPreferenceStorage implements BaseDataSource{

    private static final String PREFS_NAME = "LoginPrefs";
    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_PASSWORD = "password";

    private static LoginPreferenceStorage instance;

    private final SharedPreferences sharedPreferences;

    private LoginPreferenceStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static LoginPreferenceStorage getInstance(Context context) {
        if (instance == null) {
            instance = new LoginPreferenceStorage(context);
        }
        return instance;
    }

    public void saveLoginData(LoginData loginData) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_NAME, loginData.getUsername());
        editor.putString(KEY_PASSWORD, loginData.getPassword());
        editor.apply();
    }

    public void clearDataFromPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public Result<LoginData> getSavedLoginData() {
        String username = sharedPreferences.getString(KEY_USER_NAME, null);
        String password = sharedPreferences.getString(KEY_PASSWORD, null);
        if (username == null || password == null) {
            return new Result.Error(new IOException("No login info set"));
        } else {
            return new Result.Success<>(new LoginData(username, password));
        }
    }
}
