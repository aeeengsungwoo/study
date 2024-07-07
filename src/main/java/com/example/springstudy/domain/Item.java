package com.example.springstudy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor
public class Item {

    @Id @GeneratedValue @Column(name = "item_id")
    private Long id;
    @Column(nullable = false)
    private String itemName;
    @Column
    private Long itemPrice;
    @Column
    private Long itemAmount;
    @Column
    private String itemImageUrl;
    @Column
    private String updateAt;

}
