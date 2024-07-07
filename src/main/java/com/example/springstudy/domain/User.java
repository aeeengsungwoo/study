package com.example.springstudy.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String loginId;
    @Column
    private String password;
    @Column
    private String nickname;
    @Column
    private Long point;
    @Column
    private LocalDate createAt;
    @Column
    private LocalDate updateAt;

    @Builder(toBuilder = true)
    public User(Long userId, String loginId, String password, String nickname, Long point, LocalDate updateAt) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.point = point;
        this.createAt = LocalDate.now();
        this.updateAt = updateAt;
    }

    public void update(){
        this.nickname = getNickname();

    }
}
