package com.example.springstudy.controller;

import com.example.springstudy.dto.request.UserJoinRequestDto;
import com.example.springstudy.dto.request.UserRequestDto;
import com.example.springstudy.dto.response.ResponseDto;
import com.example.springstudy.dto.response.UserResponseDto;
import com.example.springstudy.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/topbar/username/")
    public ResponseDto<UserResponseDto> findUserName(@Valid  @RequestBody UserRequestDto userRequestDto){
        return new ResponseDto<>(userService.findById(userRequestDto));
    }

    @PostMapping("/user/join/")
    public ResponseDto<UserResponseDto> join(@Valid @RequestBody UserJoinRequestDto userJoinRequestDto){
        userService.save(userJoinRequestDto);
        return new ResponseDto<>(userService.findByName(userJoinRequestDto));
    }

    @PostMapping("/user/update/")
    public ResponseDto<UserResponseDto> modifyNickName(@Valid @RequestBody UserRequestDto userRequestDto){
        UserResponseDto updatedUser = userService.update(userRequestDto); // 업데이트된 사용자 정보 받아옴
        return new ResponseDto<>(updatedUser);
    }


}
