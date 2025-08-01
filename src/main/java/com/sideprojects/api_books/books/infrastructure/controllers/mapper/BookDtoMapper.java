package com.sideprojects.api_books.books.infrastructure.controllers.mapper;

import com.sideprojects.api_books.books.domain.model.Book;
import com.sideprojects.api_books.books.infrastructure.controllers.dto.response.BookResponseDto;

public class BookDtoMapper {
    public static BookResponseDto toDto(Book book) {
        return new BookResponseDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getAvailability(),
                book.getNumReviews(),
                book.getStars(),
                book.getDescription()
        );
    }
}
