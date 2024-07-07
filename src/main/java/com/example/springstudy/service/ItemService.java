//package com.example.springstudy.service;
//
//import com.example.springstudy.domain.Item;
//import com.example.springstudy.dto.response.ItemDto;
//import com.example.springstudy.repository.ItemRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional(readOnly=true)
//@RequiredArgsConstructor
//public class ItemService {
//
//    private final ItemRepository itemRepository;
//
//    @Transactional
//    public void saveItem(Item item){
//        itemRepository.save(item);
//    }
//
//    public List<Item> findItems(){
//        return itemRepository.findAll();
//    }
//
//    public Item findOne(Long ItemId){
//        Item item = itemRepository.findById(ItemId)
//                .orElseThrow();
//        return item;
//    }
//
////    public Page<ItemDto> getItems(String latest, String price, String name, Pageable pageable) {
////        // ... (페이징 및 정렬 로직)
////
////        Page<Item> items = itemRepository.findByItemName(name, pageable); // 페이징 처리된 결과 조회
////
////        // ... (엔티티를 DTO로 변환하여 반환)
////    }
//
//
//}
