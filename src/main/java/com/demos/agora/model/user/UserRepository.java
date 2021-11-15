
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
    
    @Modifying // update/delete의 경우 @Modifying 붙여줘야됨
    @Query(value = "UPDATE user " +
                   "SET association=:association, age=:age, sex=:sex, interest=:interest, latitude=:latitude, longitude=:longitude " +
                   "WHERE phoneNumber = :phoneNumber",nativeQuery = true)
    int m유저정보저장(@Param("association") String assocication,
                    @Param("age") String age,
                    @Param("sex") String sex,
                    @Param("interest") String interest,
                    @Param("phoneNumber") String phoneNumber,
                    @Param("latitude") Double latitude,
                    @Param("longitude") Double longitude);
}

