
package com.example.domain.models;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.Expose;

public class JsonResult {

    @Expose
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResult that = (JsonResult) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "items=" + items +
                '}';
    }
}
