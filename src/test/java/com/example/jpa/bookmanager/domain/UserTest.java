package com.example.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test(){
        User user =new User();
        user.setEmail("kim@aaa.aaa");
        user.setName("kim");

        System.out.println(">>> "+user);

//        User user1 = new User (null, "kim1","kim1@aaa.aaa", LocalDateTime.now(),LocalDateTime.now());
//        System.out.println(user1);

        User user2 = new User ("seokjin","kim2@fff.fff");
        System.out.println("user2 >>"+user2);
        User user3 = User.builder()
                .name("kim2")
                .email("kim3@fff.fff")
                .build();
        System.out.println("user3 >>"+user3);
    }

}