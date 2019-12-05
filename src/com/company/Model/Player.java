package com.company.Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    Disk disk;

    public Player() {}

    public void sortByStyle(){
        disk.sort(new SortByStyle());
    }

    public Disk getDisk() {
        return disk;
    }
    public void setDisk(Disk disk) { this.disk = disk; }

    /**
     * This function find music compositions that is playing in the diapason
     * @author Polina Serhiienko
     * @param min is the bottom bound for diapason
     * @param max is the top bound for diapason
     * @return
     */

    public List<MusicalComposition> findInDiapason(float min, float max){
        List<MusicalComposition> foundByDuration = new ArrayList<>();
        for(MusicalComposition composition: disk.getTrackList()){
            if(composition.getDuration()>min && composition.getDuration()<max)
                 foundByDuration.add(composition);
        }
        return  foundByDuration;
    }


}
