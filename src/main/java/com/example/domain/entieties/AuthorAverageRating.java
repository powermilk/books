package com.example.domain.entieties;

import java.util.Objects;

public class AuthorAverageRating {
    private String author;
    private Double averageRating;

    public AuthorAverageRating(String author, Double averageRating) {
        this.author = author;
        this.averageRating = averageRating;
    }

    public String getAuthor() {
        return author;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorAverageRating that = (AuthorAverageRating) o;
        return Objects.equals(author, that.author) &&
                Objects.equals(averageRating, that.averageRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, averageRating);
    }

    @Override
    public String toString() {
        return "AuthorAverageRating{" +
                "author='" + author + '\'' +
                ", averageRating=" + averageRating +
                '}';
    }
}
