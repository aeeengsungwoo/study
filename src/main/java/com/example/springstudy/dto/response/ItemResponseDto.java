package com.example.springstudy.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder @Getter
public class ItemResponseDto {
    private Long itemId;
    private String itemName;
    private String imageUrl;
    private Long itemPrice;
    private Long itemAmount;


}
