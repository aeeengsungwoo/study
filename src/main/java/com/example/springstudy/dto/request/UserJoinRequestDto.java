package com.example.springstudy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
@AllArgsConstructor
@ToString
@Getter
public class UserJoinRequestDto {

    private String nickname;

    private String password;

}
