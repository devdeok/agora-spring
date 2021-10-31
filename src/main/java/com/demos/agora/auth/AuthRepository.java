package com.demos.agora.auth;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthRepository extends JpaRepository<Auth,Integer> {
    // nativeQuery=true : SQL로 작성, false는 JSQL
    @Query(value = "SELECT * FROM auth WHERE phoneNumber=?1", nativeQuery = true)
    Auth 인증코드확인(String phoneNumber);
}
