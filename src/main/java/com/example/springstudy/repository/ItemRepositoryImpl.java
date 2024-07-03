package com.example.springstudy.repository;
import com.example.springstudy.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public abstract class ItemRepositoryImpl implements ItemRepository {
    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<Item> findByItemName(String itemName) {
        return em.createQuery("SELECT i FROM Item i WHERE i.itemName = :itemName", Item.class)
                .setParameter("itemName", itemName)
                .getResultList();
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

    @Override
    public Page<Item> findByItemName(String itemName, Pageable pageable) {

        // 1. 페이징 쿼리 실행
        List<Item> results = em.createQuery("SELECT i FROM Item i WHERE i.itemName = :itemName", Item.class)
                .setParameter("itemName", itemName)
                .setFirstResult((int) pageable.getOffset()) // 페이지 시작 인덱스
                .setMaxResults(pageable.getPageSize())     // 페이지 크기
                .getResultList();

        // 2. 전체 데이터 수 조회
        long total = (long) em.createQuery("SELECT COUNT(i) FROM Item i WHERE i.itemName = :itemName")
                .setParameter("itemName", itemName)
                .getSingleResult();

        // 3. Page 객체 반환
        return new PageImpl<>(results, pageable, total);
    }

}
