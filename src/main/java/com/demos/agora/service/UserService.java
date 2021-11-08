package com.demos.agora.service;

import com.demos.agora.model.user.User;
import com.demos.agora.model.user.UserRepository;
import com.demos.agora.web.dto.user.UserSaveReqDto;
import com.demos.agora.web.dto.user.UserUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

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
        userEntity.setPhoto(userUpdateReqdto.getPhoto());
        return userEntity;
    }

//    @Transactional
//    public Long registUser(UserDto form) {
//        User user = form.toEntity();
//        userRepository.save(user);
//        return user.getId();
//    }
}
