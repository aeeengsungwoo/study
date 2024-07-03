package com.example.springstudy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity @Getter
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue
    private Long orderItemId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order orderId;

    private Long orderItemAmount;
}
