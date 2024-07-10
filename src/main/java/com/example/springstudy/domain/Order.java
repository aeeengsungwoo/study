package com.example.springstudy.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Entity @Getter
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDate createAt;

    private Long totalAmount;

    private Long totalPrice;
    @Builder(toBuilder = true)
    public Order(Long orderId, User userId, OrderStatus status, LocalDate createAt, Long totalAmount, Long totalPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
        this.createAt = LocalDate.now();
        this.totalAmount = totalAmount;
        this.totalPrice = totalPrice;
    }
}
