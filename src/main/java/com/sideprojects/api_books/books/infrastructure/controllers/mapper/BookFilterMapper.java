package com.sideprojects.api_books.books.infrastructure.controllers.mapper;

import com.sideprojects.api_books.books.domain.query.BookFilter;
import com.sideprojects.api_books.books.infrastructure.controllers.dto.request.BookFilterRequest;

public class BookFilterMapper {
    public static BookFilter toDomain(BookFilterRequest request) {
        return new BookFilter(
                request.getPrice(),
                request.getPhrase()
        );
    }
}
