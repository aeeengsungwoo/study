package com.example.springstudy.repository;

import com.example.springstudy.domain.User;
import com.example.springstudy.dto.UserDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;
    @Transactional
    public void save(UserDto userDto) {
        User user = findById(userDto.getId());
        if (user == null) {
            em.persist(userDto.toEntity()); // 빌더를 사용하여 엔티티 생성 후 저장
        } else {
            // 기존 엔티티 정보 업데이트
            User updatedUser = user.toBuilder() // 빌더를 사용하여 기존 엔티티 복사
                    .loginId(userDto.getLoginId())
                    .password(userDto.getPassword())
                    .nickname(userDto.getNickname())
                    .point(userDto.getPoint())
                    .build();
            em.merge(updatedUser); // 변경된 엔티티 병합
        }
    }

    public List<User> findByName(String name){
        return em.createQuery("select m from User m where m.nickname =:name", User.class)
                .setParameter("name", name)
                .getResultList();
    }
    public User findById(Long id){
        return em.find(User.class, id);
    }
}
