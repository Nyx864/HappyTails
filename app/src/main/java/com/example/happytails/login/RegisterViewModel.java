package com.example.happytails.login;

import android.util.Patterns;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.happytails.R;
import com.example.happytails.data.dto.LoggedInUser;
import com.example.happytails.data.dto.RegisterData;
import com.example.happytails.data.repository.LoginRepository;
import com.example.happytails.utils.HashUtil;
import com.example.happytails.utils.Result;

import java.util.concurrent.CompletableFuture;

public class RegisterViewModel extends ViewModel {
    private final MutableLiveData<RegisterFormState> registerFormState = new MutableLiveData<>();
    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private final LoginRepository loginRepository;

    public RegisterViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LiveData<RegisterFormState> getRegisterFormState() {
        return registerFormState;
    }

    public LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void register(String username, String password, @Nullable String email) {
        String passwordHash = HashUtil.hashString(password);
        loginRepository.register(new RegisterData(username, passwordHash, email))
                .thenAccept(res -> {
                    loginResult.postValue(new LoginResult(new LoggedInUserView(res.getUsername())));
                }).exceptionally(e -> {
                    loginResult.postValue(new LoginResult(R.string.login_failed));
                    return null;
                });
    }

    public void registerDataChanged(String username, String password, String repeatPassword, String email) {
        if (!isUserNameValid(username)) {
            registerFormState.setValue(new RegisterFormState(
                    R.string.invalid_username,
                    null,
                    null,
                    null));
        } else if (!isPasswordValid(password)) {
            registerFormState.setValue(new RegisterFormState(
                    null,
                    R.string.invalid_password,
                    null,
                    null));
        } else if (!isRepeatPasswordValid(password, repeatPassword)) {
            registerFormState.setValue(new RegisterFormState(
                    null,
                    null,
                    R.string.invalid_repeat_password,
                    null));
        } else if (!isEmailValid(email)) {
            registerFormState.setValue(new RegisterFormState(
                    null,
                    null,
                    null,
                    R.string.invalid_email));
        } else {
            registerFormState.setValue(new RegisterFormState(true));
        }
    }

    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        return !username.trim().isEmpty();
    }

    private boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()) {
            return true;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

    private boolean isRepeatPasswordValid(String password, String repeatPassword) {
        return repeatPassword.equals(password);
    }
}
