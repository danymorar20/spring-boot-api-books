package com.sideprojects.api_books.books.domain.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private UUID id;
    private String title;
    private String author;
    private Double price;
    private Integer availability;
    private Integer numReviews;
    private Integer stars;
    private String description;
}
