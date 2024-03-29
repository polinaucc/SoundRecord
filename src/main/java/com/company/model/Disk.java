package com.company.model;

import com.company.model.entity.MusicalComposition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disk {
    private List<MusicalComposition> trackList;
    private String name;
    private float duration;
    private int amountOfTracks, freePlaceForTrack;

    public Disk(String name, int amountOfTracks) {
        this.amountOfTracks = amountOfTracks;
        this.freePlaceForTrack = amountOfTracks;
        this.name = name;
        this.trackList = new ArrayList<>();
    }

    public void addComposition(MusicalComposition composition) {
        if (freePlaceForTrack!=0) {
            trackList.add(composition);
            freePlaceForTrack--;
        } else {
            throw new IllegalArgumentException("Not enough disk space!!");
        }
    }

    public String getName() {
        return name;
    }

    public List<MusicalComposition> getTrackList() {
        return trackList;
    }

    public void sort(SortByStyle comparator) {
        Collections.sort(trackList, comparator);
    }

    public int getAmountOfTracks() {
        return amountOfTracks;
    }

    @Override
    public String toString() {
        StringBuilder tracks = new StringBuilder("Disk: \n");
        for (MusicalComposition composition : trackList) {
            tracks.append(composition.getName()).append(" ").append(composition.getAuthor()).append("\n");
        }
        return tracks.toString();
    }
}
