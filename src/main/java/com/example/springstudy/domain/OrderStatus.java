package com.example.springstudy.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
        ORDER("주문"),
        CANCEL("취소");

        private final String toKorea;
}
