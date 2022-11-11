package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Period {
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;

    public Period(String title, LocalDate startDate, LocalDate endDate, String description) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Period{" +
                "title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return title.equals(period.title) && startDate.equals(period.startDate) && endDate.equals(period.endDate) && description.equals(period.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, startDate, endDate, description);
    }

    private String description;
}
