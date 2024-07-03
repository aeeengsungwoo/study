package com.example.springstudy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String loginId;

    private String password;

    private String nickname;

    private Long point;

    private String createAt;

    private String updateAt;
    @Builder
    public User(Long userId, String loginId, String password, String nickname, Long point, String createAt, String updateAt) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.point = point;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
