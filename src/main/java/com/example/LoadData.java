package com.example;

import com.example.domain.entieties.Book;
import com.example.domain.models.ImageLinks;
import com.example.domain.models.IndustryIdentifier;
import com.example.domain.models.Item;
import com.example.domain.models.JsonResult;
import com.example.domain.models.VolumeInfo;
import com.example.helpers.BooksUtil;
import com.example.repositories.BookRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadData {

    @Value("${datasource}")
    private String datasource;

    private Logger logger = LogManager.getLogger(LoadData.class);
    @Bean
    CommandLineRunner initData(BookRepository repository) {
        if (datasource == null) {
            throw new IllegalArgumentException("VM Argument: 'datasource' is not defined!");
        }

        return args ->
            repository.saveAll(readDataFromJson());
        }

    private List<Book> readDataFromJson() {
        List<Book> books = new ArrayList<>();

        try (InputStream inputStream = getInputStream();
             JsonReader reader = new JsonReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            Gson gson = new GsonBuilder().create();

            JsonResult json = gson.fromJson(reader, JsonResult.class);

            List<Item> items = json.getItems();

            for (Item item : items) {
                VolumeInfo volumeInfo = item.getVolumeInfo();
                ImageLinks imageLinks = volumeInfo.getImageLinks();

                String isbn = volumeInfo.getIndustryIdentifiers().stream()
                        .filter(id -> "ISBN_13".equals(id.getType()))
                        .findAny()
                        .map(IndustryIdentifier::getIdentifier)
                        .orElse(item.getId());

                Book book = new Book(isbn);

                book.setTitle(volumeInfo.getTitle());
                book.setSubtitle(volumeInfo.getSubtitle());
                book.setPublisher(volumeInfo.getPublisher());

                Long publishedDate = BooksUtil.convertToUnixTimeStamp(volumeInfo.getPublishedDate());
                book.setPublishedDate(publishedDate);

                book.setDescription(volumeInfo.getDescription());
                book.setPageCount(volumeInfo.getPageCount());
                book.setThumbnailUrl(imageLinks.getThumbnail());
                book.setLanguage(volumeInfo.getLanguage());
                book.setPreviewLink(volumeInfo.getPreviewLink());
                book.setAverageRating(volumeInfo.getAverageRating());
                book.setAuthors(volumeInfo.getAuthors());
                book.setCategories(volumeInfo.getCategories());

                books.add(book);
            }

        } catch (IOException e) {
            logger.error("Cannot import data!!!", e);
        }

        return books;
    }

    private InputStream getInputStream() throws FileNotFoundException {
        return new FileInputStream(datasource);
    }
}
