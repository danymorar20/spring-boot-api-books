package com.sideprojects.api_books.books.infrastructure.controllers;

import com.sideprojects.api_books.books.application.usecase.GetAveragePriceUseCase;
import com.sideprojects.api_books.books.application.usecase.GetBooksByFilterUseCase;
import com.sideprojects.api_books.books.infrastructure.controllers.dto.request.BookFilterRequest;
import com.sideprojects.api_books.books.infrastructure.controllers.dto.response.BookResponseDto;
import com.sideprojects.api_books.books.infrastructure.controllers.mapper.BookDtoMapper;
import com.sideprojects.api_books.books.infrastructure.controllers.mapper.BookFilterMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private final GetAveragePriceUseCase getAveragePriceUseCase;
    private final GetBooksByFilterUseCase getBooksByFilterUseCase;

    public BookController(
            GetAveragePriceUseCase getAveragePriceUseCase,
            GetBooksByFilterUseCase getBooksByFilterUseCase
    ) {
        this.getBooksByFilterUseCase = getBooksByFilterUseCase;
        this.getAveragePriceUseCase = getAveragePriceUseCase;
    }

    @GetMapping
    public List<BookResponseDto> findAll(
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String phrase
    ) {
        BookFilterRequest filter = new BookFilterRequest(price, phrase);
        return getBooksByFilterUseCase.execute(BookFilterMapper.toDomain(filter))
                .stream()
                .map(BookDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/average")
    public ResponseEntity<Double> getAveragePrice() {
        return ResponseEntity.ok(getAveragePriceUseCase.execute());
    }
}
