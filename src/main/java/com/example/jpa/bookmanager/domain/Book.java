package com.example.jpa.bookmanager.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@EntityListeners(value = AuditingEntityListener.class)
public class Book implements Auditable{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt =LocalDateTime.now();
        this.updatedAt =LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt =LocalDateTime.now();
    }


}
