package com.example.jpa.bookmanager.service;

import com.example.jpa.bookmanager.domain.Book;
import com.example.jpa.bookmanager.repository.AuthorRepository;
import com.example.jpa.bookmanager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void transactionTest() {

        bookService.putBookAndAuthor();


        System.out.println("books : " + bookRepository.findAll());
        System.out.println("authors : " + authorRepository.findAll());
    }

    @Test
    void isolationTest() {
        Book book = new Book();
        book.setName("JPA강의");
        bookRepository.save(book);

        bookService.get(1L);

        System.out.println(">>>>" + bookRepository.findAll());
    }

    @Test
    void converterErrorTest() {
        bookService.getAll();

        bookRepository.findAll().forEach(System.out::println);
    }
}