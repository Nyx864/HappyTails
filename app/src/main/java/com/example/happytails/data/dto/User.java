package com.example.happytails.data.dto;

import android.graphics.drawable.Icon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private Icon pfp;
    private String description;
    private String city;
    private Gender gender;
    private String profession;

    public enum Gender {
        Male,
        Female
    }
}
