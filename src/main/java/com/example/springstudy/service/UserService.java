package com.example.springstudy.service;

import com.example.springstudy.domain.User;
import com.example.springstudy.dto.request.UserJoinRequestDto;
import com.example.springstudy.dto.request.UserRequestDto;
import com.example.springstudy.dto.response.UserResponseDto;
import com.example.springstudy.exception.ApiException;
import com.example.springstudy.exception.ErrorDefine;
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
            throw new ApiException(ErrorDefine.USER_EXIST);
        }else{
            User user = User.builder()
                    .nickname(userJoinRequestDto.getNickname())
                    .password(userJoinRequestDto.getPassword())
                    .build();
            userRepository.save(user);
        }
    }

    @Transactional
    public UserResponseDto update(UserRequestDto userRequestDto) {
        User user = userRepository.findById(userRequestDto.getId())
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

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
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        UserResponseDto userResponseDto = UserResponseDto.builder()
                .nickname(user.getNickname())
                .build();

        return userResponseDto;
    }

    public UserResponseDto findById(UserRequestDto userRequestDto) {
        User user = userRepository.findById(userRequestDto.getId())
                .orElseThrow(() -> new ApiException(ErrorDefine.USER_NOT_FOUND));

        UserResponseDto userResponseDto = UserResponseDto.builder()
                .nickname(user.getNickname())
                .build();
        return userResponseDto;
    }

}
