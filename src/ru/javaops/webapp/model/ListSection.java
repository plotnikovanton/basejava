package ru.javaops.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends Section {
    private final List<String> items;

    public ListSection(String... items) {
        this(Arrays.asList(items));
    }

    public ListSection(List<String> items) {
        Objects.requireNonNull(items,"items must not be null");
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItem(String item) {
        items.add(item);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String item : items) {
            s.append(item).append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return items != null ? items.equals(that.items) : that.items == null;
    }

    @Override
    public int hashCode() {
        return items != null ? items.hashCode() : 0;
    }
}
