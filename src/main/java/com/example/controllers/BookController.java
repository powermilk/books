package com.example.controllers;

import com.example.domain.entieties.AuthorAverageRating;
import com.example.repositories.BookRepository;
import com.example.domain.entieties.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    private static AuthorAverageRating apply(Map.Entry<String, Double> e) {
        return new AuthorAverageRating(e.getKey(), e.getValue());
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFound() {
        return new ResponseEntity<>("Result not found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/api/book/{isbn}")
    public ResponseEntity<Book> bookByIsbn(@PathVariable String isbn) {
        return Optional.ofNullable(repository.findByIsbn(isbn))
                .map(book -> ResponseEntity.ok().body(book))
                .orElseThrow(EntityNotFoundException::new);
    }

    @RequestMapping("/api/category/{category}/books")
    public List<Book> booksByCategories(@PathVariable String category) {
        return repository.findByCategories(category);
    }

    @RequestMapping("/api/rating")
    public List<AuthorAverageRating> authorRating() {

        Map<String, Double> authorBookRatingMap = new LinkedHashMap<>();
        List<Book> books = repository.findByAverageRatingNotNullOrderByAverageRatingDesc();

        books.forEach(b -> b.getAuthors()
                .forEach(author -> authorBookRatingMap.merge(author, b.getAverageRating(), (o, n) -> (o + n) / 2)));

        return authorBookRatingMap.entrySet()
                .stream()
                .map(BookController::apply)
                .collect(Collectors.toList());
    }

}