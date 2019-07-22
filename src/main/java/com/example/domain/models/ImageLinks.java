
package com.example.domain.models;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class ImageLinks {

    @Expose
    private String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageLinks that = (ImageLinks) o;
        return Objects.equals(thumbnail, that.thumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thumbnail);
    }

    @Override
    public String toString() {
        return "ImageLinks{" +
                "thumbnail='" + thumbnail + '\'' +
                '}';
    }
}

