package com.example.jpa.bookmanager.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable //Embedded를 할수잇는 클래스라는것을 알려줌
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String city;    //시

    private String district; //구

    @Column(name = "address_detail")
    private String detail; //상세주소

    private String zipCode; //우편번호
}
