package com.example.springstudy.dto.request;

import com.example.springstudy.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class ItemRequestDto {
    private Long id;

    private String itemName;

    private Long itemPrice;

    private Long itemAmount;

    private String itemImageUrl;

    private String updateAt;

}
