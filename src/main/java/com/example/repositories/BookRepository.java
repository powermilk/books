package com.example.repositories;

import com.example.domain.entieties.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    Book findByIsbn(String isbn);

    List<Book> findByCategories(String category);

    List<Book> findByAverageRatingNotNullOrderByAverageRatingDesc();
}