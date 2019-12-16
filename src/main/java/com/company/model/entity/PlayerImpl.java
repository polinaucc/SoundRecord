package com.company.model.entity;

import com.company.model.SortByStyle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlayerImpl implements Player {
    DiskImpl disk;

    @Override
    public boolean isEnteredDisk() {
        if (disk != null) return true;
        else return false;
    }

    @Override
    public void changeDisk(DiskImpl disk) {
        setDisk(disk);
    }

    @Override
    public String play() {
        return getDisk().toString();
    }

    @Override
    public void sort() {
        disk.sort(new SortByStyle());
    }

    @Override
    public List<MusicalComposition> findInDiapason(float min, float max) {
        List<MusicalComposition> foundByDuration = new ArrayList<>();
        for (MusicalComposition composition : disk.getTrackList()) {
            if (composition.getDuration() > min && composition.getDuration() < max)
                foundByDuration.add(composition);
        }
        return foundByDuration;
    }


}
