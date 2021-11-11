
package com.demos.agora.model.user;

import com.demos.agora.web.dto.user.UserRegistryReqDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    // ?1은 ?의 첫번째 파라미터를 보라는 뜻
    @Query(value = "SELECT * FROM user where phoneNumber=?1",nativeQuery = true)
    User m유저확인(String phoneNumber);

    @Query(value = "SELECT * FROM user where nickName=?1",nativeQuery = true)
    User m닉네임중복체크(String nickName);

    @Query(value = "SELECT * FROM user WHERE phoneNumber=?1",nativeQuery = true)
    User findByPhoneNumber(String phoneNumber);

    @Query(value = "UPDATE user SET association=?1,sex=?1,age=?1,interest=?1 WHERE id=?1",nativeQuery = true)
    User m유저정보저장(User user,int userId);
}
