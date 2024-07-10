package com.example.springstudy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class OrderItemRequestDto {
    private Long itemId;
    private Long itemAmount;
}
