package com.sideprojects.api_books.books.domain.repository;

import com.sideprojects.api_books.books.domain.model.Book;
import com.sideprojects.api_books.books.domain.query.BookFilter;

import java.util.List;

public interface BookRepository {
    List<Book> findByFilter(BookFilter filter);
}
