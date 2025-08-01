package com.sideprojects.api_books.books.infrastructure.persistence;

import com.sideprojects.api_books.books.domain.model.Book;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {

    @Id
    private UUID id;
    private String title;
    private String author;
    private Double price;
    private Integer availability;

    @Column(name = "num_reviews")
    private Integer numReviews;

    private Integer stars;

    @Column(length = 2048)
    private String description;

    public static Book toDomain(BookEntity entity) {
        return Book.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .price(entity.getPrice())
                .availability(entity.getAvailability())
                .numReviews(entity.getNumReviews())
                .stars(entity.getStars())
                .description(entity.getDescription())
                .build();
    }
}
