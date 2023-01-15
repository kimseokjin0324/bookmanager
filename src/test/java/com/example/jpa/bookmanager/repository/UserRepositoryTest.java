package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@SpringBootTest //-SpringContext를 연결해서 테스트하겠다라는뜻
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {

        User user = new User();
        user.setEmail("aaa");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example =Example.of(user,matcher);

        userRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void select(){

//        System.out.println(userRepository.findByName("denis"));

//        System.out.println("findByEmail : " +userRepository.findByEmail("martin@aaa.aaa"));
//        System.out.println("getByEmail : " +userRepository.getByEmail("martin@aaa.aaa"));
//        System.out.println("readByEmail : " +userRepository.readByEmail("martin@aaa.aaa"));
//        System.out.println("queryByEmail : " +userRepository.queryByEmail("martin@aaa.aaa"));
//        System.out.println("searchByEmail : " +userRepository.searchByEmail("martin@aaa.aaa"));
//        System.out.println("streamByEmail : " +userRepository.streamByEmail("martin@aaa.aaa"));
//        System.out.println("findUserByEmail : " +userRepository.findUserByEmail("martin@aaa.aaa"));
//        System.out.println("findByEmailAndName : "+userRepository.findByEmailAndName("martin@aaa.aaa","martin"));
//        System.out.println("findByEmailOrName : "+userRepository.findByEmailOrName("martin@aaa.aaa","denis"));
//        System.out.println("findByCreatedAtAfter : "+userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter : "+userRepository.findByIdAfter(1L));
//        System.out.println("findByCreatedAtGreaterThan : "+userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : "+userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtBetween : "+userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L) ,LocalDateTime.now().plusDays(1L)));
//        System.out.println("findByIdBetween : "+userRepository.findByIdBetween(1L,3L));
        System.out.println("findByIdIsNotNull : "+userRepository.findByIdIsNotNull());  //- NULL인지 체크하는 쿼리
//        System.out.println("findByAddressIsNotEmpty : "+userRepository.findByAddressIsNotEmpty());
        System.out.println("findByNameIn : "+userRepository.findByNameIn(Lists.newArrayList("martin","dennis")));
        System.out.println("findByNameStartingWith : "+userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : "+userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains : "+userRepository.findByNameContains("rti"));
        System.out.println("findByNameLike : "+userRepository.findByNameLike("%art%"));
    }
}
