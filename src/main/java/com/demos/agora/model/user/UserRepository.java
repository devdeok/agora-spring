
package com.demos.agora.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    // nativeQuery = true : SQL
    // nativeQuery = false(default) : JPQL
    // ?1은 ?의 첫번째 파라미터를 보라는 뜻
    @Query(value = "SELECT * FROM user WHERE phoneNumber=?1",nativeQuery = true)
    User m유저확인(String phoneNumber);

    @Query(value = "SELECT * FROM user WHERE nickName=?1",nativeQuery = true)
    User m닉네임중복체크(String nickName);
<<<<<<< HEAD
    
    @Modifying // update delete의 경우 붙여줘야됨
    @Query(value = "UPDATE user SET association = :association, sex = :sex, age = :age, interest = :interest WHERE phoneNumber = :phoneNumber",nativeQuery = true)
    int m유저정보저장(@Param("association") String assocication,
                     @Param("sex") String sex,
                     @Param("age") String age,
                     @Param("interest") String interest,
                     @Param("phoneNumber") String phoneNumber);
}
=======

    @Query(value = "SELECT * FROM user WHERE phoneNumber=?1",nativeQuery = true)
    User findByPhoneNumber(String phoneNumber);

    @Query(value = "UPDATE user SET association=?1,sex=?1,age=?1,interest=?1 WHERE id=?1",nativeQuery = true)
    User m유저정보저장(User user,int userId);
}
>>>>>>> b2a97e3fc91323478ed6cea1dca770f0124ce932
