package com.example.jpa.bookmanager.domain;

import com.example.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor  //- 아무런 인자안주는 생성자 만들기(JPA에서는 인자없는 생서자 필요)
@AllArgsConstructor //- 모든인자 생성자 만들기
@RequiredArgsConstructor     //- 꼭필요한 인자만 생성자만들어줌
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@EntityListeners(value = UserEntityListener.class)
public class User extends BaseEntity {

    @Id //-PK지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull    //- 필수값이됨
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories = new ArrayList<>();  //null 값 방지용 new ArrayList로 세팅

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();
}
