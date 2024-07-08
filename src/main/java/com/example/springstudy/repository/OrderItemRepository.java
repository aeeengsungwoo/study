package com.example.springstudy.repository;

import com.example.springstudy.domain.Order;
import com.example.springstudy.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
//    List<OrderItem> findByOrderId(Long orderId);
    @Query("SELECT oi FROM OrderItem oi WHERE oi.orderId = :orderId")
    List<OrderItem> findByOrderId(@Param("orderId") Order orderId);
//    @Query("SELECT oi.orderId FROM OrderItem oi WHERE oi.orderItemId = :orderItemId")
//    List<OrderItem> findOrderIdByOrderItemId(@Param("orderItemId") Long orderItemId);
}
