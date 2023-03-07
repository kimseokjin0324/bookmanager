package com.example.jpa.bookmanager.domain;

import com.example.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass   //- 해당클래스의 필드를 상속받는 Entity컬럼에 추가한다.
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements Auditable {

    @CreatedDate
    @Column(columnDefinition = "datetime(6) default now(6)",nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "datetime(6) default now(6)",nullable = false)
    private LocalDateTime updatedAt;


}
