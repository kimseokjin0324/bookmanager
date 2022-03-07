package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

//    List<User> findByAddressIsNotEmpty();       // name is not null and name != ''??

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContains(String name);

    List<User> findLast1ByName(String name);

    List<User> findTop1ByNameOrderByIdDesc(String name);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);       //-아이디는 내림차순, email은 오름차순

    List<User> findFirstByName(String name, Sort sort);

    Page<User> findByName(String name, Pageable pageable);  // Page 응답을 하는 응답값 ,Pageable는 요청값

    @Query(value = "select * from user limit 1;", nativeQuery = true)
    Map<String, Object> findRowRecord();
}
