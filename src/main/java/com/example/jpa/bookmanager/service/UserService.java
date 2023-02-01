package com.example.jpa.bookmanager.service;

import com.example.jpa.bookmanager.domain.User;
import com.example.jpa.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;


    @Transactional
    public void put() {
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@aaa.aaa");

        entityManager.persist(user);    //entityManager로 영속화 직접 진행

        entityManager.detach(user);
        user.setName("newUserAfterPersist");

        entityManager.merge(user);
        entityManager.flush();
        entityManager.clear();

    }
}
