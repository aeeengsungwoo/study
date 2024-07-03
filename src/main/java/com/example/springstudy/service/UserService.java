package com.example.springstudy.service;

import com.example.springstudy.domain.User;
import com.example.springstudy.dto.UserDto;
import com.example.springstudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void saveUser(UserDto userdto){
        userRepository.save(userdto);
    }

    private void validateDuplicateMember(User user) {
        List<User> findMembers = userRepository.findByName(user.getNickname());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public User findById(Long id){
        return userRepository.findById(id);
    }


}
