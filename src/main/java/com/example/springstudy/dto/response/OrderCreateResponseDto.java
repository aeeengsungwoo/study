package com.example.springstudy.dto.response;

import com.example.springstudy.domain.Order;
import com.example.springstudy.domain.OrderStatus;
import com.example.springstudy.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter
@ToString
public class OrderCreateResponseDto {

    private Long orderId;

    private Long userId;

    private OrderStatus status;

    private Long totalAmount;

    private Long totalPrice;

    private LocalDate createAt;
}
