package com.example.springstudy.service;

import com.example.springstudy.domain.*;
import com.example.springstudy.dto.request.OrderCreateRequestDto;
import com.example.springstudy.dto.response.ItemResponseDto;
import com.example.springstudy.dto.response.OrderCreateResponseDto;
import com.example.springstudy.dto.response.OrderResponseDto;
import com.example.springstudy.exception.ApiException;
import com.example.springstudy.exception.ErrorDefine;
import com.example.springstudy.repository.ItemRepository;
import com.example.springstudy.repository.OrderItemRepository;
import com.example.springstudy.repository.OrderRepository;
import com.example.springstudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public OrderResponseDto findItemByOrderId(Long orderId) {
        // 1. 주문 ID로 주문 엔티티 조회 (OrderRepository 사용)
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ApiException(ErrorDefine.ORDER_NOT_FOUND));

        // 2. 주문 ID로 주문 항목 엔티티 조회 (OrderItemRepository 사용)
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(order);
        // orderId는 Long이기 때문에 order를 넣어줘야함 + findByOrderId쿼리문에서 반환 타입을 Order로 해줘야함

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
        OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                .orderId(order.getOrderId())
                // 필요한 다른 주문 정보 추가 (예: 주문 날짜, 총 금액 등)
                .items(itemResponseDtos) // 아이템 정보 리스트 포함
                .build();

        return orderResponseDto;
    }

    public OrderCreateResponseDto orderCreate(OrderCreateRequestDto orderCreateRequestDto){
        // 1. 주문 빌드, 저장
        User user = userRepository.findById(orderCreateRequestDto.getUserId())
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        Order order = Order.builder()
                .userId(user) // User 엔티티와의 연관관계 설정
                .totalPrice(orderCreateRequestDto.getTotalPrice()) // total price 계산 로직 추가 필요
                .totalAmount(orderCreateRequestDto.getTotalAmount())
                .status(OrderStatus.ORDER) // 초기 주문 상태 설정
                .build();

        Order savedOrder = orderRepository.save(order);

        // 2. orderItem 빌드, 저장
        List<OrderItem> orderItems = orderCreateRequestDto.getOrderItems().stream()
                .map(itemRequestDto -> {
                    Item item = itemRepository.findById(itemRequestDto.getItemId())
                            .orElseThrow(() -> new ApiException(ErrorDefine.ITEM_NOT_FOUND));

                    return OrderItem.builder()
                            .orderId(savedOrder) // 위에서 save한 order의 ID참조
                            .item(item)
                            .orderItemAmount(itemRequestDto.getItemAmount())
                            .build();
                })
                .collect(Collectors.toList());

        orderItemRepository.saveAll(orderItems);

        // 3. OrderCreateResponseDto 생성 및 반환
        OrderCreateResponseDto orderCreateResponseDto = OrderCreateResponseDto.builder()
                .orderId(savedOrder.getOrderId()) // 저장된 주문의 ID 사용
                .userId(savedOrder.getUserId().getUserId()) // 연관관계를 통해 User ID 가져오기
                .totalPrice(savedOrder.getTotalPrice())
                .totalAmount(savedOrder.getTotalAmount())
                .status(savedOrder.getStatus())
                .build();

        return orderCreateResponseDto;
    }


}
