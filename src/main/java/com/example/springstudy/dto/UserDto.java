package com.example.springstudy.dto;

import com.example.springstudy.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class UserDto {

    private Long id;

    private String loginId;

    private String password;

    private String nickname;

    private Long point;

    private String createAt;

    private String updateAt;
    public User toEntity() {
        return User.builder()
                .userId(id)
                .loginId(loginId)
                .password(password)
                .nickname(nickname)
                .point(point)
                .createAt(createAt)
                .updateAt(updateAt)
                .build();
    }

}
