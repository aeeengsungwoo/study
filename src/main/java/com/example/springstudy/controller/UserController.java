package com.example.springstudy.controller;

import com.example.springstudy.dto.request.UserJoinRequestDto;
import com.example.springstudy.dto.request.UserRequestDto;
import com.example.springstudy.dto.response.UserResponseDto;
import com.example.springstudy.dto.response.ResponseData;
import com.example.springstudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/topbar/username/")
    public ResponseData<UserResponseDto> findUserName(@RequestBody UserRequestDto dto){
        return new ResponseData<>(200, "유저 닉네임",userService.findById(dto));
    }

    @PostMapping("/user/join/")
    public ResponseData<UserResponseDto> join(@RequestBody UserJoinRequestDto dto){
        userService.save(dto);
        return new ResponseData<>(200, "회원가입 완료",userService.findByName(dto));
    }
    @PostMapping("/user/update/")
    public ResponseData<UserResponseDto> modifyNickName(@RequestBody UserRequestDto dto){
        userService.update(dto);
        return new ResponseData<>(200, "닉네임 수정",userService.findById(dto));
    }


}
