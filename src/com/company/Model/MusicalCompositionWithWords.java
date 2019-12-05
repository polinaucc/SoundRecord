package com.company.Model;

public class MusicalCompositionWithWords extends MusicalComposition {
    String language;


    public MusicalCompositionWithWords(String name, String author, String style, float duration, String language) {
        super(name, author, style, duration);
        this.language = language;
    }
}
