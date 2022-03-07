package com.example.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@EntityListeners(value = {MyEntityListener.class,UserEntityListener.class})
public class User implements Auditable{
    @Id             //PK
    @GeneratedValue //순차적으로 값을 자동으로 추가시켜주기 위해서
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //    @OneToMany(fetch = FetchType.EAGER)

}
