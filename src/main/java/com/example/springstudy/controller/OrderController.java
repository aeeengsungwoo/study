package com.example.springstudy.controller;

import com.example.springstudy.dto.response.ItemResponseDto;
import com.example.springstudy.dto.response.OrderResponseDto;
import com.example.springstudy.dto.response.ResponseDto;
import com.example.springstudy.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/{orderId}")
    public ResponseDto<OrderResponseDto> findItemByOrderId(@PathVariable("orderId") Long orderId) {
        OrderResponseDto orderResponseDto = orderService.findItemByOrderId(orderId); // 주문 ID로 조회
        return new ResponseDto<>(orderResponseDto); // 조회된 결과 반환
    }
}
