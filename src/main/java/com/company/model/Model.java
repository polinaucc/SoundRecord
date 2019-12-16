package com.company.model;

import com.company.model.entity.MusicalComposition;
import com.company.model.entity.MusicalCompositionWithWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private Player player;
    private List<Disk> disks;
    private Disk currentDisk;
    private List<MusicalComposition> compositions;

    public Player getPlayer() {
        return player;
    }

    public Model() {
        this.player = new Player();
        compositions = new ArrayList<>(Arrays.asList(
                new MusicalCompositionWithWords("Song1", "Singer1", "рок", 3f, "Ukrainian"),
                new MusicalCompositionWithWords("Song2", "Singer2", "хіп-хоп", 2.45f, "Russian"),
                new MusicalCompositionWithWords("Song3", "Singer3", "поп", 3f, "Ukrainian"),
                new MusicalCompositionWithWords("Song4", "Singer4", "класична музика", 2.45f, "Russian")
        ));
        disks = new ArrayList<>(Arrays.asList(
                new Disk("disk1", 1),
                new Disk("disk2", 2),
                new Disk("disk3", 3)
        ));
    }

    public List<Disk> getDisks() {
        return disks;
    }

    public void setCurrentDisk(String nameOfCurrentDisk) {
        for (Disk d : disks) {
            if (d.getName().equals(nameOfCurrentDisk)) {
                this.currentDisk = d;
                break;
            }
        }
    }

    public Disk getCurrentDisk() {
        return currentDisk;
    }

    public List<MusicalComposition> getCompositions() {
        return compositions;
    }

    public void recordCompositionOnDisk(String... composition) {
        for (MusicalComposition mc : this.getCompositions()) {
            for (String mc2 : composition) {
                if (mc.getName().equals(mc2)) {
                    currentDisk.addComposition(mc);
                }
            }
        }
    }
}

