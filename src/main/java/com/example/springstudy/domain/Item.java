package com.example.springstudy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity @Getter
public class Item {
    @Id @GeneratedValue
    private Long itemId;

    private String itemName;

    private Long itemPrice;

    private Long itemAmount;

    private String itemImageUrl;

    private String updateAt;


}
