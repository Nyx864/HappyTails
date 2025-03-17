package com.example.happytails.data.repository;

import com.example.happytails.data.dto.RegisterData;
import com.example.happytails.data.dto.SingInData;
import com.example.happytails.data.source.LoginDataSource;
import com.example.happytails.data.dto.LoggedInUser;

import java.util.concurrent.CompletableFuture;

public class LoginRepository{

    private static volatile LoginRepository instance;

    private final LoginDataSource dataSource;

    private CompletableFuture<LoggedInUser> user = CompletableFuture.completedFuture(null);

    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
        updateLoggedInUser();
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user.join() != null;
    }

    public CompletableFuture<LoggedInUser> getLoggedInUser() {
        return user;
    }

    public void setLoggedInUser(CompletableFuture<LoggedInUser> loggedInUser) {
        user = loggedInUser;
    }

    public CompletableFuture<LoggedInUser> singIn(SingInData singInData) {
        CompletableFuture<LoggedInUser> res = dataSource.singIn(singInData);
        setLoggedInUser(res);
        return res;
    }

    public CompletableFuture<LoggedInUser> register(RegisterData registerData) {
        CompletableFuture<LoggedInUser> res = dataSource.register(registerData);
        setLoggedInUser(res);
        return res;
    }

    public void updateLoggedInUser() {
        user = dataSource.getLoggedInUser();
    }

    public void logout() {
        setLoggedInUser(CompletableFuture.completedFuture(null));
        dataSource.logout();
    }
}