package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Album {
    List<MusicalComposition> album = new ArrayList<>();
    float duration;
    int amountOfTracks, freePlaceForTrack = amountOfTracks;

    public Album(int amountOfTracks) {
        this.amountOfTracks = amountOfTracks;
    }

    public void addComposition(MusicalComposition... composition){
        for(MusicalComposition c: composition)
        album.add(c);
    }

    public float countDuration() {
        for (MusicalComposition composition : album) {
            if (amountOfTracks > album.size()) {
                duration += composition.getDuration();
                freePlaceForTrack--;
            }

        }
        return duration;
    }

    public List<MusicalComposition> getAlbum() {
        return album;
    }

    public void sort(SortByStyle comparator){
        Collections.sort(album, comparator);
    }

    @Override
    public String  toString() {
        StringBuilder tracks = new StringBuilder("Album: \n");
        for (MusicalComposition composition : album) {
            tracks.append(composition.getName()).append(" ").append(composition.getAuthor()).append("\n");
        }
        return tracks.toString();
    }
}
