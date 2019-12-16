package com.company.model.entity;

import com.company.model.SortByStyle;

public interface Disk {
    void addComposition(MusicalComposition composition);
    void removeComposition(String name);
    void sort(SortByStyle comparator);
}
