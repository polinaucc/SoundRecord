package com.company.model.entity;

import com.company.model.Style;
import lombok.*;

@Getter
@Setter
public abstract class MusicalComposition {

    protected String name, author;
    protected Style style;
    protected float duration;

    public MusicalComposition() { }

    public MusicalComposition(String name, String author, String styleName, float duration) {
        this.name = name;
        this.author = author;
        this.style = Style.getValueByTitle(styleName);
        if(this.style==null) throw new IllegalArgumentException("Incorrect style name");
        if (duration < 0) throw new IllegalArgumentException("The duration must be more than 0");
        this.duration = duration;
    }
}
