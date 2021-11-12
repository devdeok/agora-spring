
package com.demos.agora.service;

import com.demos.agora.model.user.User;
import com.demos.agora.model.user.UserRepository;
import com.demos.agora.web.dto.user.UserRegistryReqDto;
import com.demos.agora.web.dto.user.UserSaveReqDto;
import com.demos.agora.web.dto.user.UserUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    // @Modifying : insert, update, delete과 DDL구문 사용시 표기
    // @Transactional : update, delete 사용 시 표기
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User 유저확인(String phoneNumber) {
        return userRepository.m유저확인(phoneNumber);
    }

    @Transactional(readOnly = true)
    public User 유저ID로확인(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            return new IllegalArgumentException();
        });
    }

    @Transactional(readOnly = true)
    public User 닉네임중복체크(String nickName) {
        return userRepository.m닉네임중복체크(nickName);
    }

    @Transactional
    public User 회원가입(UserSaveReqDto userSaveReqDto) {
        return userRepository.save(userSaveReqDto.toEntity());
    }

    @Transactional
    public User 닉네임AND프로필변경(int id, UserUpdateReqDto userUpdateReqdto) {
        // 영속화
        User userEntity = userRepository.findById(id).get();
        userEntity.setNickName(userUpdateReqdto.getNickName());
        return userEntity;
    }

    @Transactional
    public int 유저정보(UserRegistryReqDto userRegistryReqDto) {
        String phoneNumber = userRegistryReqDto.getPhoneNumber();
        String association = userRegistryReqDto.toEntity().getAssociation();
        String age = userRegistryReqDto.toEntity().getAge();
        String sex = userRegistryReqDto.toEntity().getSex();
        String interest = userRegistryReqDto.toEntity().getInterest();

        return userRepository.m유저정보저장(association,age,sex,interest,phoneNumber); // error
    }
}

