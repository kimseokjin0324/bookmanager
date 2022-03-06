package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {   //C: CREATE R: READ U: UPDATE D: DELETE

        User user1 = new User("jack", "jack@gmail.com");
        User user2 = new User("james", "james@gmail.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));

        List<User> users=userRepository.findAll();

        users.forEach(System.out::println);


    }

}