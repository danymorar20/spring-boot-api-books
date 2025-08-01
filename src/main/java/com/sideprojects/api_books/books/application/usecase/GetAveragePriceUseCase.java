package com.sideprojects.api_books.books.application.usecase;

import com.sideprojects.api_books.books.domain.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class GetAveragePriceUseCase {
    private final BookRepository bookRepository;

    public GetAveragePriceUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Double execute() {
        Double avg = bookRepository.getAveragePrice();
        if (avg == null) return 0.0;

        return BigDecimal.valueOf(avg)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
