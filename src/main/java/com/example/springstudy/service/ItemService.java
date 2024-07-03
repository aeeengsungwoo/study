package com.example.springstudy.service;

import com.example.springstudy.domain.Item;
import com.example.springstudy.dto.ItemDto;
import com.example.springstudy.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long ItemId){
        return itemRepository.findOne(ItemId);
    }

//    public Page<ItemDto> getItems(String latest, String price, String name, Pageable pageable) {
//        // 1. 정렬 기준 생성 (최신순, 가격순)
//
//
//        if (latest != null) {
//            sortedPageable = pageable.withSort(Sort.by(Sort.Direction.fromString(latest), "updateAt"));
//        }
//        if (price != null && !price.equals(latest)) { // 최신순과 가격순이 다를 경우에만 추가
//            sortedPageable = sortedPageable.withSort(Sort.by(Sort.Direction.fromString(price), "itemPrice"));
//        }
//
//        // 2. 검색 조건 생성 (이름) 및 데이터 조회
//        Page<Item> items = itemRepository.findByItemNameContaining(name, sortedPageable);
//
//        // 3. 엔티티를 DTO로 변환하여 반환
//        return items.map(ItemDto::new);
//    }

}
