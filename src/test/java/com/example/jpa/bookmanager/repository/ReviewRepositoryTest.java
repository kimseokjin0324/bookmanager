package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    void reviewTest() {
//        List<Review> reviews = reviewRepository.findAll();
        List<Review> reviews = reviewRepository.findAllByEntityGraph();
////        System.out.println(reviews);
//        System.out.println("전체를 가져왔습니다.");
//
//        System.out.println(reviews.get(0).getComments());
//
//        System.out.println("첫review의 코멘트를 가져왔습니다.");
//
//        System.out.println(reviews.get(1).getComments());
//
//        System.out.println("두번째 review의 코멘트를 가져왔습니다.");
        reviews.forEach(System.out::println);
    }
}
