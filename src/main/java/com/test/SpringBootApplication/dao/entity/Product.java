package com.test.SpringBootApplication.dao.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id @Setter(AccessLevel.PROTECTED) Long id;
    private String type;
    private String color;
    private Integer gblimit;
    private Double price;
    private String address;
}
