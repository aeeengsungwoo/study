package com.example.springstudy.service;

import com.example.springstudy.domain.User;
import com.example.springstudy.dto.request.UserJoinRequestDto;
import com.example.springstudy.dto.request.UserRequestDto;
import com.example.springstudy.dto.response.UserResponseDto;
import com.example.springstudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void save(UserJoinRequestDto userJoinRequestDto){
        if (userRepository.existsByNickname(userJoinRequestDto.getNickname())){
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }else{
            User user = User.builder()
                    .nickname(userJoinRequestDto.getNickname())
                    .password(userJoinRequestDto.getPassword())
                    .build();
            userRepository.save(user);

        }
    }
//    @Transactional
//    public void update(UserRequestDto userRequestDto){
//        User user = userRepository.findById(userRequestDto.getId())
//                .orElseThrow();
//        user.update();
//    }
    @Transactional
    public UserResponseDto update(UserRequestDto userRequestDto) {
        User user = userRepository.findById(userRequestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        user.update(userRequestDto.getNickname());

        // user 엔티티를 다시 저장하여 변경 사항을 DB에 반영
        user = userRepository.save(user);
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .nickname(user.getNickname()) // 업데이트된 닉네임을 반환
                .build();
        return userResponseDto;
    }
    public UserResponseDto findByName(UserJoinRequestDto userJoinRequestDto) {
        User user = userRepository.findByNickname(userJoinRequestDto.getNickname())
                .orElseThrow();

        UserResponseDto userResponseDto = UserResponseDto.builder()
                .nickname(user.getNickname())
                .build();

        return userResponseDto;
    }

    public UserResponseDto findById(UserRequestDto userRequestDto) {
        User user = userRepository.findById(userRequestDto.getId())
                .orElseThrow();
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .nickname(user.getNickname())
                .build();
        return userResponseDto;
    }



}
