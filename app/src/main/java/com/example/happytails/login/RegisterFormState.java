package com.example.happytails.login;

import androidx.annotation.Nullable;

import lombok.Getter;

@Getter
public class RegisterFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer passwordError;
    @Nullable
    private Integer repeatPasswordError;
    @Nullable
    private Integer emailError;
    private boolean isDataValid;

    RegisterFormState(@Nullable Integer usernameError,
                      @Nullable Integer passwordError,
                      @Nullable Integer repeatPasswordError,
                      @Nullable Integer emailError) {
        this.repeatPasswordError = repeatPasswordError;
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.emailError = emailError;
        this.isDataValid = false;
    }

    RegisterFormState(boolean isDataValid) {
        this.repeatPasswordError = null;
        this.usernameError = null;
        this.passwordError = null;
        this.emailError = null;
        this.isDataValid = isDataValid;
    }
}
