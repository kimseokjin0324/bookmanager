package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    List<User> findByEmailAndName(String email, String name);

    List<User> findByEmailOrName(String email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday,LocalDateTime tomorrow);

    List<User> findByIdBetween(Long id, Long id2);

    List<User> findByIdIsNotNull();

//    List<User> findByAddressIsNotEmpty();

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContains(String name);

    List<User> findByNameLike(String name);

    @Query(value = "select * from user limit 1",nativeQuery = true)
    Map<String,Object> findRowRecord();
}
