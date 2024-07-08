package com.example.springstudy.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class OrderResponseDto {
    private Long orderId;
    private List<ItemResponseDto> items;
}
