package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Address;
import com.example.jpa.bookmanager.domain.Gender;
import com.example.jpa.bookmanager.domain.User;
import com.example.jpa.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@SpringBootTest //-SpringContext를 연결해서 테스트하겠다라는뜻
class UserRepositoryTest {


    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void crud() {

        User user = new User();
        user.setEmail("aaa");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void select() {

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());  //- NULL인지 체크하는 쿼리
        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));
        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("rti"));
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%art%"));
    }


    @Test
    void insertAndUpdateTest() {
        User user = new User();

        user.setName("martin");
        user.setEmail("martin22@aaa.aaa");
        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrtin");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);
        System.out.println(userRepository.findRowRecord().get("gender"));

    }

    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("martin22@aaa.aaa");
        user.setName("martin");

        userRepository.save(user);  // insert가 일어남

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("maraaartin");

        userRepository.save(user2);

        userRepository.deleteById(4L);

    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("martin22@bva.com");
        user.setName("martin");

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("martin22@bva.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as -is:" + user);
        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to-be: " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("martinnew@aaa.aaa");
        user.setName("test1");

        userRepository.save(user);

        user.setName("test1-1");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);


    }

    @Test
    void userRelationTest() {
        User user = new User();
        user.setName("david");
        user.setEmail("david@test.com");
        user.setGender(Gender.MALE);

        userRepository.save(user);

        user.setName("daniel");

        userRepository.save(user);

        user.setEmail("daniel@test2.com");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("daniel@test2.com").getId()
//        );
        List<UserHistory> result =
                userRepository
                        .findByEmail("daniel@test2.com")
                        .getUserHistories();    //- 위 코드와 동일 한 기능을 하는 데 @OneToMany를 이용함

        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser());
    }



    @Test
    void embedTest() {
        userRepository.findAll().forEach(System.out::println);

        User user = new User();
        user.setName("steve");
        user.setHomeAddress(new Address("서울시", "강남구", "강남대로 364 석진빌딩", "08123"));
        user.setCompanyAddress(new Address("서울시", "종로구", "교보문고 12층", "1234"));
        userRepository.save(user);

        User user1 = new User();
        user1.setName("Joshua");
        user1.setHomeAddress(null);
        user1.setCompanyAddress(null);
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Jordan");
        user2.setHomeAddress(new Address());
        user2.setCompanyAddress(new Address());
        userRepository.save(user2);

        entityManager.clear();

        userRepository.findAll().forEach(System.out::println);
        userHistoryRepository.findAll().forEach(System.out::println);
        userRepository.findAllRowRecord().forEach(a-> System.out.println(a.values()));

        assertAll(
                ()->assertThat(userRepository.findById(7L).get().getHomeAddress()).isNull(),
                ()->assertThat(userRepository.findById(8L).get().getHomeAddress()).isInstanceOf(Address.class)
        );
    }
}
