package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Gender;
import com.example.jpa.bookmanager.domain.User;
import com.example.jpa.bookmanager.domain.UserHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;


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


//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("park@gmail.com", "park"));
//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("park@gmail.com", "park"));
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdIsNotNull : "+userRepository.findByIdIsNotNull());
//        System.out.println("findByAddressIsNotEmpty : "+userRepository.findByAddressIsNotEmpty());
//        System.out.println("findByNameIn : "+userRepository.findByNameIn(Lists.newArrayList("kim","lee")));
//        System.out.println("findByNameStartingWith : "+userRepository.findByNameStartingWith("pa"));
//        System.out.println("findByNameEndingWith : "+userRepository.findByNameEndingWith("rk"));
//        System.out.println("findByNameContains : "+userRepository.findByNameContains("ar"));
    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("park"));
        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("park"));  //- 이키워드는 무시되어서 findByName 쿼리가 실행이 된다
        System.out.println("findTop1ByNameOrderByIdDesc : " + userRepository.findTop1ByNameOrderByIdDesc("park"));  //- 위 키워드에게 원했던 기능
        System.out.println("findFirstByNameOrderByIdDescEmailAsc :  " + userRepository.findFirstByNameOrderByIdDescEmailAsc("park"));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("park", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findByNameWithPaging : " + userRepository.findByName("park", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent()); //-page값은 0인덱스 값임을 알아 놔야함
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setName("martin");
        user.setEmail("martin@gmai.com");

        userRepository.save(user);  //insert

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrtin");
        userRepository.save(user2); //update
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
        user.setEmail("kim@gamil.com");
        user.setName("kim");

        userRepository.save(user);      //Insert 가 진행

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        user2.setName("kimmmmmm");
        userRepository.save(user2);     //Update

        userRepository.deleteById(4L);      //delete

    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("kimseokjin03@gamil.com");
        user.setName("kimseok");

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("kimseokjin03@gamil.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        System.out.println("as-is : " + user);
        user.setName("lee sin");
        userRepository.save(user);
        System.out.println("to-be :  " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setName("kim-new");
        user.setEmail("kim-new@gmail.com");

        userRepository.save(user);

        user.setName("kim-new-new");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void userRelationTest() {
        User user = new User();
        user.setName("david");
        user.setEmail("david@gmail.com");
        user.setGender(Gender.MALE);
        userRepository.save(user);

        user.setName("daniel");
        userRepository.save(user);

        user.setEmail("daniel@gmail.com");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
        //- userHistory가 엄청 쌓여있다면 findAll로 가져오면 X userId값을 특정하여 findById값으로 가져와야할 것이다.
//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("daniel@gmail.com").getId()
//        );

        List<UserHistory> result = userRepository.findByEmail("daniel@gmail.com").getUserHistories();
        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser());

    }
}