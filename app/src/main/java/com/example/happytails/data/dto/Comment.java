package com.example.happytails.data.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    private User user;
    private Post post;
    private String text;
    private int reputation;
    private LocalDateTime sendTime;
}
