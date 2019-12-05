package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Disk {
    private List<MusicalComposition> trackList = new ArrayList<>();
    private String name;
    private float duration;
    private int amountOfTracks, freePlaceForTrack;

    public Disk (String name, int amountOfTracks, float duration) {
        this.amountOfTracks = amountOfTracks;
        this.freePlaceForTrack = amountOfTracks;
        this.name = name;
        this.duration = duration;
    }

    public void addComposition(MusicalComposition... composition){
        for(MusicalComposition c: composition) {
            if (this.duration >  this.getTracksDuration() + c.getDuration()) {
                trackList.add(c);
            } else {
                throw new IllegalArgumentException("Not enough disk space!!");
            }
        }
    }

    public String getName() {
        return name;
    }

    public float getTracksDuration() {
        int duration = 0;
        for (MusicalComposition composition : trackList) {
            duration += composition.getDuration();
        }
        return duration;
    }

    public List<MusicalComposition> getTrackList() {
        return trackList;
    }

    public void sort(SortByStyle comparator){
        Collections.sort(trackList, comparator);
    }

    public int getFreePlaceForTrack() {
        return freePlaceForTrack;
    }

    @Override
    public String  toString() {
        StringBuilder tracks = new StringBuilder("Disk: \n");
        for (MusicalComposition composition : trackList) {
            tracks.append(composition.getName()).append(" ").append(composition.getAuthor()).append("\n");
        }
        return tracks.toString();
    }
}
