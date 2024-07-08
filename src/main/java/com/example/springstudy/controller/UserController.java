package com.example.springstudy.controller;

import com.example.springstudy.dto.request.UserJoinRequestDto;
import com.example.springstudy.dto.request.UserRequestDto;
import com.example.springstudy.dto.response.ResponseDto;
import com.example.springstudy.dto.response.UserResponseDto;
import com.example.springstudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/topbar/username/")
    public ResponseDto<UserResponseDto> findUserName(@RequestBody UserRequestDto dto){
        return new ResponseDto<>(userService.findById(dto));
    }

    @PostMapping("/user/join/")
    public ResponseDto<UserResponseDto> join(@RequestBody UserJoinRequestDto dto){
        userService.save(dto);
        return new ResponseDto<>(userService.findByName(dto));
    }

    @PostMapping("/user/update/")
    public ResponseDto<UserResponseDto> modifyNickName(@RequestBody UserRequestDto dto){
        UserResponseDto updatedUser = userService.update(dto); // 업데이트된 사용자 정보 받아옴
        return new ResponseDto<>(updatedUser);
    }


}
