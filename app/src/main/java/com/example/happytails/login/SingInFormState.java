package com.example.happytails.login;

import androidx.annotation.Nullable;

import lombok.Getter;

@Getter
class SingInFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer passwordError;
    private boolean isDataValid;

    SingInFormState(@Nullable Integer usernameError,
                    @Nullable Integer passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    SingInFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }
}