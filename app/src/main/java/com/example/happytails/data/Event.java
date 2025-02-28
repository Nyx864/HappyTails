package com.example.happytails.data;

import android.graphics.drawable.Icon;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
    private Icon image;
    private String name;
    private String description;
    private LocalDateTime startTime;
}
