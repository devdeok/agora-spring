package com.demos.agora.service;

import com.demos.agora.user.User;
import com.demos.agora.user.UserRepository;
import com.demos.agora.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long registUser(UserDto form) {
        User user = form.toEntity();
        userRepository.save(user);
        return user.getId();
    }
}
