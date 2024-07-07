package com.example.springstudy.dto.request;

import com.example.springstudy.domain.Item;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ItemDto {
    private Long id;

    private String itemName;

    private Long itemPrice;

    private Long itemAmount;

    private String itemImageUrl;

    private String updateAt;
    public ItemDto(Item item) {
        this.id = item.getId();
        this.itemName = item.getItemName();
        this.itemPrice = item.getItemPrice();
        this.itemAmount = item.getItemAmount();
        this.itemImageUrl = item.getItemImageUrl();
        this.updateAt = item.getUpdateAt();
    }

}
