package com.example.springstudy.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity @Getter
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order orderId; // 이게 Order객체로 되어있어서 Long 값으로 이 값을 조회할 수가 없음

    private Long orderItemAmount;


    public Long getItemId() {
        return item.getId();
    }
    @Builder(toBuilder = true)
    public OrderItem(Long orderItemId, Item item, Order orderId, Long orderItemAmount) {
        this.orderItemId = orderItemId;
        this.item = item;
        this.orderId = orderId;
        this.orderItemAmount = orderItemAmount;
    }
}
