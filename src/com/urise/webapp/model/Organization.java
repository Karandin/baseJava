package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private String website;
    private final String name;
    private final List<Period> periods;

    public Organization(String name, List<Period> periods, String website) {
        this.name = name;
        this.periods = periods;
        this.website = website;
    }

    public Organization(String name, List<Period> periods) {
        this(name,periods,null);
    }

    public String getName() {
        return name;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    @Override
    public String toString() {
        return "Organization{" +
                "website='" + website + '\'' +
                ", name='" + name + '\'' +
                ", periods=" + periods +
                '}';
    }
}
