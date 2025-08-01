package com.sideprojects.api_books.books.infrastructure.controllers.dto.request;

import lombok.Getter;

@Getter
public class BookFilterRequest {
    private Double price;
    private String phrase;

    public BookFilterRequest(Double price, String phrase) {
        this.price = price;
        this.phrase = phrase;
    }
}
