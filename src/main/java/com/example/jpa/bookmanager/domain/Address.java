package com.example.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Address {
    @Id             //PK
    @GeneratedValue //순차적으로 값을 자동으로 추가시켜주기 위해서
    private Long id;

}
