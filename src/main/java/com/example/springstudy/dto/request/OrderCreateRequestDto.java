package com.example.springstudy.dto.request;

import com.example.springstudy.domain.OrderStatus;
import com.example.springstudy.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


@AllArgsConstructor
@ToString
@Getter
public class OrderCreateRequestDto {

    private Long userId;

    private OrderStatus status;

    private Long totalAmount;

    private Long totalPrice;

    private List<OrderItemRequestDto> orderItems;
}
