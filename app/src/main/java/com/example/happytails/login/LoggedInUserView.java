package com.example.happytails.login;

import java.util.concurrent.Future;

import lombok.Getter;

@Getter
public class LoggedInUserView {
    private final String displayName;

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }
}