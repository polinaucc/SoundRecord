package com.company.model.entity;

public enum Style {
    ROCK(1950, "Рок", "Найпопулярніший стиль 90-х"),
    POP(1980, "Поп", "Напрям массового музикування"),
    CLASSIC(1750, "Класична музика", "Лікувальна дія відома ще з давніх часів"),
    HIPHOP(1970, "Хіп-хоп", "Цей напрямок музики складається з декількох жанрів: починаючи від «легких» стилів (поп-реп), закінчуючи агресивними (хардкор, гороркор).");

    private int foundationYear;
    private String name;
    private String description;

    Style(int foundationYear, String name, String description) {
        this.foundationYear = foundationYear;
        this.name = name;
        this.description = description;
    }

    public static Style getValueByTitle(String name){
        for(Style s: Style.values()){
            if(s.name.equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getFoundationYear() {
        return foundationYear;
    }
}
