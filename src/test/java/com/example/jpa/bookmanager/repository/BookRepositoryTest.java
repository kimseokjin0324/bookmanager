package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Book;
import com.example.jpa.bookmanager.domain.Publisher;
import com.example.jpa.bookmanager.domain.Review;
import com.example.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("아무거나 만든 책");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);
        bookRepository.save(book);

        System.out.println(bookRepository.findAll().get(0));
    }

    @Test
    @Transactional
    void bookRelationTest() {
        //1. book정보와 review정보를 저장
        givenBookAndReview();

        User user = userRepository.findByEmail("lee@gmail.com");

        System.out.println("Review :" + user.getReviews());
        System.out.println("Book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher :" + user.getReviews().get(0).getBook().getPublisher());
    }

    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));

    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("테스트 북네임");
        book.setPublisher(publisher);
        return bookRepository.save(book);
    }

    private User givenUser() {
        return userRepository.findByEmail("lee@gmail.com");
    }

    private void givenReview(User user, Book book) {
        Review review = new Review();

        review.setTitle("내 인생을 바꾼 책");
        review.setContent("너무너무 테스트");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("김석진 테스트");

        return publisherRepository.save(publisher);
    }
}