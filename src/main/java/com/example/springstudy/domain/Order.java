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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public Order(User userId, OrderStatus status, Long totalAmount, Long totalPrice) {
        this.userId = userId;
        this.status = status;
        this.createAt = LocalDate.now();
        this.totalAmount = totalAmount;
        this.totalPrice = totalPrice;
    }
}
