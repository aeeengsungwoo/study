package com.example.springstudy.repository;

import com.example.springstudy.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByNickname(String nickname);
}


//
//import com.example.springstudy.domain.User;
//import com.example.springstudy.dto.response.UserDto;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityNotFoundException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@Repository
//@RequiredArgsConstructor
//public class UserRepository {
//
//    private final EntityManager em;
//    @Transactional
//    public void save(UserDto userDto) {
//        User user = findById(userDto.getId());
//        if (user == null) {
//            em.persist(userDto.toEntity()); // 빌더를 사용하여 엔티티 생성 후 저장
//        } else {
//            // 기존 엔티티 정보 업데이트
//            User updatedUser = user.toBuilder() // 빌더를 사용하여 기존 엔티티 복사
//                    .nickname(userDto.getNickname())
//                    .build();
//            em.merge(updatedUser); // 변경된 엔티티 병합
//        }
//    }
//
//    public List<User> findByName(String name){
//        return em.createQuery("select m from User m where m.nickname =:name", User.class)
//                .setParameter("name", name)
//                .getResultList();
//    }
//    public Optional<User findById(Long id){
//        try{
//            User user = em.find(User.class,id);
//            return user;
//        } catch (EntityNotFoundException e) {
//            return null;
//        }
////        return em.find(User.class, id);
//    }
//}
