package com.example.springstudy.controller;

import com.example.springstudy.dto.UserDto;
import com.example.springstudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/topbar/username/")
    public String findUserName(@RequestBody UserDto dto){
        return userService.findById(dto.getId()).getNickname();
    }

    @GetMapping("/user/modify/")
    public void modifyName(@RequestBody UserDto dto){
        userService.saveUser(dto);
    }

//    @GetMapping("/user/create/")
//    public String join(@RequestBody UserDto dto){
//        userService.join(dto);
//        return userService.findById(dto.getId()).getNickname();
//    }

}
