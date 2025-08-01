package com.sideprojects.api_books.books.application.usecase;

import com.sideprojects.api_books.books.domain.model.Book;
import com.sideprojects.api_books.books.domain.query.BookFilter;
import com.sideprojects.api_books.books.domain.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetBooksByFilterUseCase {
    private final BookRepository bookRepository;

    public GetBooksByFilterUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> execute(BookFilter filter) {
        return bookRepository.findByFilter(filter);
    }
}
