package com.example.jpa.bookmanager.domain;

import com.example.jpa.bookmanager.domain.listener.Auditable;
import com.example.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor  //- 아무런 인자안주는 생성자 만들기(JPA에서는 인자없는 생서자 필요)
@AllArgsConstructor //- 모든인자 생성자 만들기
@RequiredArgsConstructor     //- 꼭필요한 인자만 생성자만들어줌
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@EntityListeners(value= UserEntityListener.class)
//@Table(name ="user",indexes={@Index(columnList = "name")},uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User extends BaseEntity {

    @Id //-PK지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull    //- 필수값이됨
    private String email;

//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

//    @Transient  //- 영속성처리에 제외 DB에는 제외
//    private String testData;
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;
//    @PrePersist
//    @PreUpdate  //merge 메소드가 호출되기전 호출됨
//    @PreRemove
//    @PostPersist
//    @PostUpdate // merge 메소드 호출후 호출
//    @PostRemove
//    @PostLoad   // -select 조회가 일어난 직후

//    @PrePersist //실무에서 가장많이 쓰임
//    public void prePersist(){
//        this.createdAt=LocalDateTime.now();
//        this.updatedAt=LocalDateTime.now();
//    }
//
//
//    @PreUpdate //실무에서 가장많이쓰임
//    public void preUpdate(){
//        this.updatedAt=LocalDateTime.now();
//    }

}
