package com.sideprojects.api_books.books.infrastructure.controllers.dto.response;

import java.util.UUID;

public class BookResponseDto {
    public UUID id;
    public String title;
    public String author;
    public Double price;
    public Integer availability;
    public Integer numReviews;
    public Integer stars;
    public String description;

    public BookResponseDto(UUID id, String title, String author, Double price,
                           Integer availability, Integer numReviews, Integer stars, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
        this.numReviews = numReviews;
        this.stars = stars;
        this.description = description;
    }
}
