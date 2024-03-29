package com.company.model;

import com.company.model.entity.MusicalComposition;

import java.util.Comparator;

public class SortByStyle implements Comparator<MusicalComposition> {
    public int compare(MusicalComposition mc1, MusicalComposition mc2){
       return mc1.getStyle().compareTo(mc2.getStyle());
    };
}
