package com.example.happytails.data.dto;

import android.graphics.drawable.Icon;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pet {
    private String name;
    private Icon pfp;
    private String description;
    private List<Pet> friends;
    private List<Post> posts;
}
