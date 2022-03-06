package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {   //C: CREATE R: READ U: UPDATE D: DELETE
        userRepository.save(new User("david", "david@gmail.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("kimseokjin-updated@gmail.com");

        userRepository.save(user);
    }

    @Test
    void select() {
        System.out.println(userRepository.findByName("kim"));
//        System.out.println("findByEmail : " + userRepository.findByEmail("lee@gmail.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("lee@gmail.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("lee@gmail.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("lee@gmail.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("lee@gmail.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("lee@gmail.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("lee@gmail.com"));
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("lee"));
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("lee"));


        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("park@gmail.com", "park"));
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("park@gmail.com", "park"));
        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(3L));
    }


}