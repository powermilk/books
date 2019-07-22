package com.example.domain.models;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class Item {

    @Expose
    private String id;
    @Expose
    private VolumeInfo volumeInfo;

    public String getId() {
        return id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(volumeInfo, item.volumeInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, volumeInfo);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", volumeInfo=" + volumeInfo +
                '}';
    }
}
