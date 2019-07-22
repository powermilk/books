
package com.example.domain.models;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.Expose;

public class VolumeInfo {

    @Expose
    private List<IndustryIdentifier> industryIdentifiers;
    @Expose
    private String title;
    @Expose
    private String subtitle;
    @Expose
    private String publisher;
    @Expose
    private String publishedDate;
    @Expose
    private String description;
    @Expose
    private Integer pageCount;
    @Expose
    private ImageLinks imageLinks;
    @Expose
    private String language;
    @Expose
    private String previewLink;
    @Expose
    private Double averageRating;
    @Expose
    private List<String> authors;
    @Expose
    private List<String> categories;

    public List<IndustryIdentifier> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<String> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VolumeInfo that = (VolumeInfo) o;
        return Objects.equals(industryIdentifiers, that.industryIdentifiers) &&
                Objects.equals(title, that.title) &&
                Objects.equals(subtitle, that.subtitle) &&
                Objects.equals(publisher, that.publisher) &&
                Objects.equals(publishedDate, that.publishedDate) &&
                Objects.equals(description, that.description) &&
                Objects.equals(pageCount, that.pageCount) &&
                Objects.equals(imageLinks, that.imageLinks) &&
                Objects.equals(language, that.language) &&
                Objects.equals(previewLink, that.previewLink) &&
                Objects.equals(averageRating, that.averageRating) &&
                Objects.equals(authors, that.authors) &&
                Objects.equals(categories, that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(industryIdentifiers, title, subtitle, publisher, publishedDate, description, pageCount, imageLinks, language, previewLink, averageRating, authors, categories);
    }

    @Override
    public String toString() {
        return "VolumeInfo{" +
                "industryIdentifiers=" + industryIdentifiers +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", imageLinks=" + imageLinks +
                ", language='" + language + '\'' +
                ", previewLink='" + previewLink + '\'' +
                ", averageRating=" + averageRating +
                ", authors=" + authors +
                ", categories=" + categories +
                '}';
    }
}
