package com.example.happytails.data.model;

import android.graphics.drawable.Icon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {
    private Icon image;
    private String name;
    private String description;
    private String groupName;
}
