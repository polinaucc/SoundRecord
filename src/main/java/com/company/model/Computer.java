package com.company.model;

import com.company.model.entity.DiskImpl;
import com.company.model.entity.MusicalComposition;
import com.company.model.entity.MusicalCompositionWithWords;
import com.company.model.entity.PlayerImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {
    private PlayerImpl player;
    private List<DiskImpl> disks;
    private DiskImpl currentDisk;
    private List<MusicalComposition> compositions;

    public PlayerImpl getPlayer() {
        return player;
    }

    public Computer() {
        this.player = new PlayerImpl();
        compositions = new ArrayList<>(Arrays.asList(
                new MusicalCompositionWithWords("Song1", "Singer1", "рок", 3f, "Ukrainian"),
                new MusicalCompositionWithWords("Song2", "Singer2", "хіп-хоп", 2.45f, "Russian"),
                new MusicalCompositionWithWords("Song3", "Singer3", "поп", 3f, "Ukrainian"),
                new MusicalCompositionWithWords("Song4", "Singer4", "класична музика", 2.45f, "Russian")
        ));
        disks = new ArrayList<>(Arrays.asList(
                new DiskImpl("disk1", 1),
                new DiskImpl("disk2", 2),
                new DiskImpl("disk3", 3)
        ));
    }

    public List<DiskImpl> getDisks() {
        return disks;
    }

    public void setCurrentDisk(String nameOfCurrentDisk) {
        for (DiskImpl d : disks) {
            if (d.getName().equals(nameOfCurrentDisk)) {
                this.currentDisk = d;
                break;
            }
        }
    }

    public DiskImpl getCurrentDisk() {
        return currentDisk;
    }

    public List<MusicalComposition> getCompositions() {
        return compositions;
    }

    public boolean isExist(MusicalComposition composition) {
        for (MusicalComposition mc : this.getCompositions()) {
            if (mc.getName().equals(composition)) {
                return true;
            }
        }
        return false;
    }

    public void recordCompositionOnDisk(String... composition) {
        for (MusicalComposition mc : this.getCompositions()) {
            if (isExist(mc)) currentDisk.addComposition(mc);
        }
    }
}


