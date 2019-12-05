package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    Disk disk;

    public Player() {}
    public Player(Disk disk) {
        this.disk = disk;
    }

    public String getTrackList(){
        return disk.toString();
    }

    public void sortByStyle(){
        disk.sort(new SortByStyle());
    }

    public Disk getDisk() {
        return disk;
    }
    public void setDisk(Disk disk) { this.disk = disk; }

    public List<MusicalComposition> findInDiapason(float min, float max){
        List<MusicalComposition> foundByDuration = new ArrayList<>();
        for(MusicalComposition composition: disk.getDisk()){
            if(composition.getDuration()>min && composition.getDuration()<max)
                 foundByDuration.add(composition);
        }
        return  foundByDuration;
    }


}
