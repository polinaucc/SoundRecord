package com.company.model.entity;

import java.util.List;

public interface Player {
    boolean isEnteredDisk();
    void changeDisk(DiskImpl disk);
    String  play();
    void sort();
    List<MusicalComposition> findInDiapason(float min, float max);
}
