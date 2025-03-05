package com.example.happytails.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Share {
    private Post post;
    private User user;
}
