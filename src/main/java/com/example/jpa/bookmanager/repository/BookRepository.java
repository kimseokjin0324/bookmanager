package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Book;
import com.example.jpa.bookmanager.repository.dto.BookNameAndCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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

    @Query(value = "select * from book", nativeQuery = true)
    List<Book> findAllCustom();

    @Transactional
    @Modifying
    @Query(value = "update book set category ='TT전문서' ", nativeQuery = true)
    int updateCategories();

    @Query(value = "show tables", nativeQuery = true)
    List<String> showTables();
}
