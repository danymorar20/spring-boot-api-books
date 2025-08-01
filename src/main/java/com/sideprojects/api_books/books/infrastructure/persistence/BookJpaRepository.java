package com.sideprojects.api_books.books.infrastructure.persistence;

import com.sideprojects.api_books.books.domain.model.Book;
import com.sideprojects.api_books.books.domain.query.BookFilter;
import com.sideprojects.api_books.books.domain.repository.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookJpaRepository implements BookRepository {

    private final SpringDataBookRepository springDataBookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public BookJpaRepository(SpringDataBookRepository springDataBookRepository) {
        this.springDataBookRepository = springDataBookRepository;
    }

    @Override
    public List<Book> findByFilter(BookFilter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> criteriaQuery = criteriaBuilder.createQuery(BookEntity.class);
        Root<BookEntity> root = criteriaQuery.from(BookEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getMinPrice() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), filter.getMinPrice()));
        }

        if (filter.getAuthorContains() != null) {
            predicates.add(criteriaBuilder.and(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("author")), "%o%"),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("author")), "%z%")
            ));
        }

        if (!predicates.isEmpty()) {
            criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        }

        return entityManager.createQuery(criteriaQuery)
                .getResultList()
                .stream()
                .map(BookEntity::toDomain)
                .toList();
    }

    @Override
    public Double getAveragePrice() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);

        Root<BookEntity> root = criteriaQuery.from(BookEntity.class);
        criteriaQuery.select(criteriaBuilder.avg(root.get("price")));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
