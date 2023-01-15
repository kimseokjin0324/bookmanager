package com.example.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor  //- 아무런 인자안주는 생성자 만들기(JPA에서는 인자없는 생서자 필요)
@AllArgsConstructor //- 모든인자 생성자 만들기
@RequiredArgsConstructor     //- 꼭필요한 인자만 생성자만들어줌
@Data
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull    //- 필수값이됨
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
