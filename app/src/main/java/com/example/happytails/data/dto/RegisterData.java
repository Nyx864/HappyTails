package com.example.happytails.data.dto;

import androidx.annotation.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterData {
    String username;
    String password;
    @Nullable String email;
}
