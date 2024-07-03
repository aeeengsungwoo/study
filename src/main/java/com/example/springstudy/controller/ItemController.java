package com.example.springstudy.controller;

import com.example.springstudy.domain.Item;
import com.example.springstudy.dto.ItemDto;
import com.example.springstudy.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @Slf4j @RequiredArgsConstructor
@RequestMapping("/customers/item")
public class ItemController {

    private final ItemService itemService;

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
