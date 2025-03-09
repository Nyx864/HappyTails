package com.example.happytails.data.model;

import android.graphics.drawable.Icon;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
    private List<User> collaborators;
    private Icon contentIcon;
    private String description;
    private List<Like> likes;
    private List<Comment> comments;
    private List<Share> shares;
}
