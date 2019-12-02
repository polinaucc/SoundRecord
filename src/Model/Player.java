package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    Album album ;

    public Player(Album album) {
        this.album = album;
    }

    public String getTrackList(){
        return album.toString();
    }

    public void sortByStyle(){
        album.sort(new SortByStyle());
    }

    public Album getAlbum() {
        return album;
    }

    public List<MusicalComposition> findInDiapason(float min, float max){
        List<MusicalComposition> foundByDuration = new ArrayList<>();
        for(MusicalComposition composition: album.getAlbum()){
            if(composition.getDuration()>min && composition.getDuration()<max)
                 foundByDuration.add(composition);
        }
        return  foundByDuration;
    }


}
