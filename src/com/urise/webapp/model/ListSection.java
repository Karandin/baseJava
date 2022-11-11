package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection{
    private List<String> list;

    @Override
    public String toString() {
        return "ListSection{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    public List<String> getList() {
        return list;
    }

    public ListSection(List<String> list) {
        this.list = list;
    }
}
