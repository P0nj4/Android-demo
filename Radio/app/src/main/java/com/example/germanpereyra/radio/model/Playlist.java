package com.example.germanpereyra.radio.model;

import java.util.ArrayList;

/**
 * Created by germanpereyra on 22/Jul/16.
 */
public class Playlist {
    private String color;
    private String name;
    private String description;

    public Playlist(String color, String name, String description) {
        this.color = color;
        this.name = name;
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
