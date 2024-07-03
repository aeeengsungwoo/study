package com.example.springstudy.repository;
import com.example.springstudy.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        if (item.getId()==null){ // 새로운 상품을 등록하는 경우엔 당연히 id값이 없다.
            em.persist(item); // 그렇기 때문에 새로운 아이템 값을 저장해주는 것.
        }else {
            em.merge(item); // 근데 만약 id값이 존재하는 경우에는 이미 저장되어있던 상품의 정보를 업데이트 하는 것
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
    public Page<Item> findByItemNameContaining(String name, Pageable pageable) {
        String jpql = "select i from Item i";

        if (StringUtils.hasText(name)) {
            jpql += " where i.itemName like :name";
        }

        TypedQuery<Item> query = em.createQuery(jpql, Item.class);
        if (StringUtils.hasText(name)) {
            query.setParameter("name", "%" + name + "%");
        }

        // 페이징 처리
        int total = query.getResultList().size(); // 전체 데이터 수
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()); // 페이지 시작 위치
        query.setMaxResults(pageable.getPageSize()); // 페이지당 데이터 수

        List<Item> content = query.getResultList();

        return new PageImpl<>(content, pageable, total);
    }



}
