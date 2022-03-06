package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name); //-일반적으로 findBy라는 네이밍규칙을 많이 사용함

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    List<User> findFirst1ByName(String name);

    List<User> findTop1ByName(String name);

    List<User> findByEmailAndName(String email, String name);

    List<User> findByEmailOrName(String email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<User> findByIdIsNotNull();

    List<User> findByAddressIsNotEmpty();       // name is not null and name != ''??

    List<User> findByNameIn(List<String> names);
}
