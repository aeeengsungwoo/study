package com.example.springstudy.repository;

import com.example.springstudy.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemName(String name);

    Page<Item> findByItemName(String itemName, Pageable pageable); // 페이징 추가

}
