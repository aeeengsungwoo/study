package com.example.springstudy.dto.request;

import com.example.springstudy.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter
public class UserRequestDto {

    private Long id;

    private String nickname;

}
