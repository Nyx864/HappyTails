package com.example.happytails.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.happytails.R;
import com.example.happytails.data.dto.SingInData;
import com.example.happytails.data.repository.LoginRepository;
import com.example.happytails.utils.HashUtil;

class SingInViewModel extends ViewModel {

    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private final LoginRepository loginRepository;

    public SingInViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void singIn(String username, String password) {
        String passwordHash = HashUtil.hashString(password);
        loginRepository.singIn(new SingInData(username, passwordHash))
                .thenAccept(res -> {
                    loginResult.postValue(new LoginResult(new LoggedInUserView(res.getUsername())));
                }).exceptionally(e -> {
                    loginResult.postValue(new LoginResult(R.string.invalid_sing_in_data));
                    return null;
                });
    }
}