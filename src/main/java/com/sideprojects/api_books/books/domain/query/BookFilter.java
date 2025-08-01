package com.sideprojects.api_books.books.domain.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookFilter {
    private Double minPrice;
    private String authorContains;

    public BookFilter(Double minPrice, String authorContains) {
        this.minPrice = minPrice;
        this.authorContains = authorContains;
    }
}
