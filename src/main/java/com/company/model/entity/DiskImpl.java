package com.company.model.entity;

import com.company.model.SortByStyle;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Setter
@Getter
public class DiskImpl implements Disk {
    private List<MusicalComposition> trackList;
    private String name;
    private float duration;
    private int amountOfTracks, freePlaceForTrack;

    public DiskImpl(String name, int amountOfTracks) {
        this.amountOfTracks = amountOfTracks;
        this.freePlaceForTrack = amountOfTracks;
        this.name = name;
        this.trackList = new ArrayList<>();
    }

    @Override
    public void addComposition(MusicalComposition composition) {
        if (freePlaceForTrack!=0) {
            trackList.add(composition);
            freePlaceForTrack--;
        } else {
            throw new IllegalArgumentException("Not enough disk space!!");
        }
    }

    private int findIndexByName(String name){
        for(MusicalComposition mc: trackList){
            if (mc.getName().equals(name))
                return trackList.indexOf(mc);
        }
        throw new NoSuchElementException("There are no song with such name");
    }

    @Override
    public void removeComposition(String name) {
        trackList.remove(findIndexByName(name));

    }

    @Override
    public void sort(SortByStyle comparator) {
        Collections.sort(trackList, comparator);
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
