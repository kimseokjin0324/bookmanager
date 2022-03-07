package com.example.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
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
//    private List<Address> address;
    @PrePersist     //인서트 메서드가 호출되기 전에 실행되는 메소드
    public void prePersist() {
        System.out.println(">>>> prePersist");
    }

    @PostPersist
    public void postPersist() {
        System.out.println(">>>> postPersist");
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println(">>>> preUpdate");
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println(">>>> postUpdate");
    }

    @PreRemove
    public void preRemove() {
        System.out.println(">>>> preRemove");
    }

    @PostRemove
    public void postRemove() {
        System.out.println(">>>> postRemove");
    }

    @PostLoad
    public void postLoad(){
        System.out.println(">>> postLoad");
    }

}
