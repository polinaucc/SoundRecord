package com.company.Model;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }


    public Style getStyle() {
        return style;
    }


    public float getDuration() {
        return duration;
    }

}
