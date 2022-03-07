package com.example.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void user() {

        User user = new User();
        user.setEmail("kimseokjin0324@gmail.com");
        user.setName("kimseokjin");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

//        User user1 = new User(null, "seokjin", "kimseokjin0324@gmail.com", LocalDateTime.now(), LocalDateTime.now());
//        System.out.println(user1);
        System.out.println(user);
        User user2 = new User("seokjin", "kimseokjin0324@gmail.com");
        System.out.println(user2);

        User user3 = User.builder()
                .name("kimseokjin")
                .email("sw3e13@naver.com")
                .build();

        System.out.println(user3);

    }

}