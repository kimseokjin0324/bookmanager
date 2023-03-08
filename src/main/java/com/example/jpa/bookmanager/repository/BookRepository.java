package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Book;
import com.example.jpa.bookmanager.repository.dto.BookNameAndCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByCategoryIsNull();

    List<Book> findAllByDeletedFalse();

    List<Book> findByCategoryIsNullAndDeletedFalse();

    List<Book> findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(String name, LocalDateTime createdAt
            , LocalDateTime updatedAt);

    @Query(value = "select b from Book b where name = ?1 and createdAt >= ?2 and updatedAt >= ?3 and category is null")
    List<Book> findByNameRecently(String name, LocalDateTime createdAt, LocalDateTime updateAt);

    @Query(value = "select new com.example.jpa.bookmanager.repository.dto.BookNameAndCategory(b.name, b.category) from Book b ")
    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select new com.example.jpa.bookmanager.repository.dto.BookNameAndCategory(b.name, b.category) from Book b ")
    List<BookNameAndCategory> findBookNameAndCategory(Pageable pageable);
}
