package com.example.springstudy.service;

import com.example.springstudy.domain.Order;
import com.example.springstudy.domain.OrderItem;
import com.example.springstudy.domain.Item;
import com.example.springstudy.dto.response.ItemResponseDto;
import com.example.springstudy.dto.response.OrderResponseDto;
import com.example.springstudy.exception.ApiException;
import com.example.springstudy.exception.ErrorDefine;
import com.example.springstudy.repository.ItemRepository;
import com.example.springstudy.repository.OrderItemRepository;
import com.example.springstudy.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;

    public OrderResponseDto findItemByOrderId(Long orderId) {
        // 1. 주문 ID로 주문 엔티티 조회 (OrderRepository 사용)
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ApiException(ErrorDefine.ORDER_NOT_FOUND));

        // 2. 주문 ID로 주문 항목 엔티티 조회 (OrderItemRepository 사용)
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(orderId);

        // 3. 주문 항목 엔티티에서 아이템 ID 추출
        List<Long> itemIds = orderItems.stream()
                .map(OrderItem::getItemId)
                .collect(Collectors.toList());

        // 4. 아이템 ID 리스트로 아이템 엔티티 조회 (ItemRepository 사용)
        List<Item> items = itemRepository.findAllById(itemIds);

        // 5. 아이템 엔티티 리스트를 ItemResponseDto 리스트로 변환
        List<ItemResponseDto> itemResponseDtos = items.stream()
                .map(item -> ItemResponseDto.builder()
                        .itemId(item.getId())
                        .itemName(item.getItemName())
                        .imageUrl(item.getItemImageUrl())
                        .itemPrice(item.getItemPrice())
                        .itemAmount(item.getItemAmount())
                        .build())
                .collect(Collectors.toList());

        // 6. OrderResponseDto 생성 및 반환
        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                // 필요한 다른 주문 정보 추가 (예: 주문 날짜, 총 금액 등)
                .items(itemResponseDtos) // 아이템 정보 리스트 포함
                .build();
    }

}
