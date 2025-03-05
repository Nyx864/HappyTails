package com.example.happytails.data;

import android.graphics.drawable.Icon;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pet {
    String name;
    Icon pfp;
    String description;
    List<Pet> friends;
    List<Post> posts;
}
