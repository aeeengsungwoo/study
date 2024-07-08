package com.example.springstudy.controller;

import com.example.springstudy.dto.response.ItemResponseDto;
import com.example.springstudy.dto.response.ResponseDto;
import com.example.springstudy.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @Slf4j @RequiredArgsConstructor
@RequestMapping
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/Item/{itemId}")
    public ResponseDto<ItemResponseDto> findItemByOrderId(@PathVariable("itemId") String orderId) {
        ItemResponseDto itemResponseDto = itemService.findByItemId(orderId); // 주문 ID로 조회
        return new ResponseDto<>(itemResponseDto); // 조회된 결과 반환
    }

//    @GetMapping
//    public ResponseEntity<Item> getItems(
//            @RequestParam(defaultValue = "desc") String latest,
//            @RequestParam(defaultValue = "desc") String price,
//            @RequestParam(required = false) String name,
//            Pageable pageable
//    ){
//        Page<ItemDto> items = itemService.getItems(latest, price, name, pageable);
//        return ResponseEntity.ok(items);
//    }


}
