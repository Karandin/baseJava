package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private String website;
    private String name;
    private List<Period> periods;

    public Organization(String name, List<Period> periods) {
        this.name = name;
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "website='" + website + '\'' +
                ", name='" + name + '\'' +
                ", periods=" + periods +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(website, that.website) && name.equals(that.name) && periods.equals(that.periods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(website, name, periods);
    }
}
