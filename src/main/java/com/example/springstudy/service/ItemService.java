package com.example.springstudy.service;

import com.example.springstudy.domain.Item;
import com.example.springstudy.domain.User;
import com.example.springstudy.dto.request.ItemRequestDto;
import com.example.springstudy.dto.request.UserJoinRequestDto;
import com.example.springstudy.dto.response.ItemResponseDto;
import com.example.springstudy.dto.response.UserResponseDto;
import com.example.springstudy.exception.ApiException;
import com.example.springstudy.exception.ErrorDefine;
import com.example.springstudy.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public ItemResponseDto findByItemName(ItemRequestDto itemRequestDto) {
        Item item = itemRepository.findByItemName(itemRequestDto.getItemName())
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        ItemResponseDto itemResponseDto = ItemResponseDto.builder()
                .itemName(item.getItemName())
                .build();

        return itemResponseDto;
    }

    public ItemResponseDto findByItemId(String itemId) {
        Item item = itemRepository.findById(Long.parseLong(itemId)) // orderId를 Long 타입으로 변환
                .orElseThrow(() -> new ApiException(ErrorDefine.ITEM_NOT_FOUND));


        ItemResponseDto itemResponseDto = ItemResponseDto.builder()
                .itemName(item.getItemName())
                .build();
        return itemResponseDto;
    }


}
