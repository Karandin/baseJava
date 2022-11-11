package com.urise.webapp.model;

public enum SectionType {
    PERSONAL("Позиция"),
    OBJECTIVE("Личные качества"),
    ACHIVEMENT("Достижения"),
    QUALIFICATION("Квалификация"),
    EXPERIENCE("Опыт"),
    EDUCATION("Образование");

    private String title;

    SectionType(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
