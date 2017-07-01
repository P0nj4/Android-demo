package com.example.germanpereyra.radio.service;

import com.example.germanpereyra.radio.model.Playlist;
import com.example.germanpereyra.radio.model.Station;

import java.util.ArrayList;

/**
 * Created by germanpereyra on 21/Jul/16.
 */
public class DataService {
    private static DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Station> getFeacturedStations() {
        ArrayList<Station> stations = new ArrayList<Station>();
        stations.add(new Station("Flight Plan tunes for travel", "flightplanmusic"));
        stations.add(new Station("Two-we lorem ipsum chupamela", "bicyclemusic"));
        stations.add(new Station("kids childs music for childtren", "kidsmusic"));
        return stations;
    }

    public ArrayList<Station> getRecentStations() {
        ArrayList<Station> stations = new ArrayList<Station>();
        stations.add(new Station("Flight Plan tunes for travel", "flightplanmusic"));
        stations.add(new Station("Two-we lorem ipsum chupamela", "bicyclemusic"));
        stations.add(new Station("kids childs music for childtren", "kidsmusic"));
        return stations;
    }

    public ArrayList<Station> getPartyStations() {
        ArrayList<Station> stations = new ArrayList<Station>();
        stations.add(new Station("Flight Plan tunes for travel", "flightplanmusic"));
        stations.add(new Station("Two-we lorem ipsum chupamela", "bicyclemusic"));
        stations.add(new Station("kids childs music for childtren", "kidsmusic"));
        return stations;
    }

    public ArrayList<Playlist> getPlayLists() {

        ArrayList<Playlist> playlists = new ArrayList<Playlist>();

        playlists.add(new Playlist("#ABC029", "international playlist", "Celebrate music from around the world with this eclectic mix of sounds and artists"));
        playlists.add(new Playlist("#30BCF4", "international playlist", "Celebrate music from around the world with this eclectic mix of sounds and artists"));
        playlists.add(new Playlist("#FB5A00", "international playlist", "Celebrate music from around the world with this eclectic mix of sounds and artists"));

        return playlists;
    }
}
