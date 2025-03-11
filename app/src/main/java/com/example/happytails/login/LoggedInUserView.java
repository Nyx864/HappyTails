package com.example.happytails.login;

import lombok.Getter;

@Getter
class LoggedInUserView {
    private final String displayName;

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }
}