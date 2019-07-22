package com.example.domain.models;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class IndustryIdentifier {

    @Expose
    private String identifier;
    @Expose
    private String type;

    public String getIdentifier() {
        return identifier;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndustryIdentifier that = (IndustryIdentifier) o;
        return Objects.equals(identifier, that.identifier) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, type);
    }

    @Override
    public String toString() {
        return "IndustryIdentifier{" +
                "identifier='" + identifier + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
