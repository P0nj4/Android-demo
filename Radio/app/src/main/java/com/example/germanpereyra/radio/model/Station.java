package com.example.germanpereyra.radio.model;

/**
 * Created by germanpereyra on 21/Jul/16.
 */
public class Station {

    private final String DRAWABLE = "drawable/";

    private String stationTitle;
    private String imgUri;


    public Station(String stationTitle, String imgUri) {
        this.stationTitle = stationTitle;
        this.imgUri = imgUri;
    }

    public String getStationTitle() {
        return stationTitle;
    }

    public String getImgUri() {
        return DRAWABLE + imgUri;
    }
}
