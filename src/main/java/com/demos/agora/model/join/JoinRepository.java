package com.demos.agora.model.join;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JoinRepository extends JpaRepository<Join, JoinKey> {
    
    // StudyService에서 userId를 받아야함
    // 스터디를 생성한 사용자는 그룹장 권한을 가지고 있어야하므로 role을 1로 설정
    // memberSince는 CURRENT_DATE로 기본값 설정 : 생성시 현재날짜가 들어감
    @Query(value = "INSERT INTO `join`(studyId, userId, role) VALUES(?1,?2,1)",nativeQuery = true)
    int 사용자스터디생성(int studyId, int userId);
    
    // StudyService에서 userId를 받아야함
    // 스터디에 가입한 사용자는 그룹원 권한을 가지고 있으므로 role을 0으로 설정
    @Query(value = "INSERT INTO `join`(studyId, userId, role) VALUES(?1,?2,0)",nativeQuery = true)
    int 사용자스터디가입(int studyId, int userId);
}
