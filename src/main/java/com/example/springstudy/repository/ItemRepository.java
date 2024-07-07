//package com.example.springstudy.repository;
//
//import com.example.springstudy.domain.Item;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface ItemRepository extends JpaRepository<Item, Long> {
//    List<Item> findByItemName(String name);
//    Optional<Item> findById(Long id);
//
//    Page<Item> findByItemName(String itemName, Pageable pageable); // 페이징 추가
//
//}
