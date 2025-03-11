package com.example.happytails.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoggedInUser {
    private String userId;
    private String username;
}