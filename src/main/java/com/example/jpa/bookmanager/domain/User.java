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
@Table(indexes = {@Index(columnList = "name")},uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
    @Id             //PK
    @GeneratedValue //순차적으로 값을 자동으로 추가시켜주기 위해서
    private Long id;
    @NonNull
    private String name;
    @NonNull
    @Column
    private String email;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Transient
    private String testData;
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
