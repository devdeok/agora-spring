package com.demos.agora.model.study;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {

    @Query(value = "SELECT * FROM study ORDER BY createdate desc", nativeQuery = true)
    List<Study> 전체최신순정렬();

/*
    @Query(value = "SELECT * FROM study", nativeQuery = true)
    List<Study> 필터링된스터디목록(String interest, String order);
*/

    @Query(value = "SELECT * FROM study ORDER BY mood desc", nativeQuery = true)
    List<Study> 전체추천순정렬();
    
    // 현재는 모든 스터디 정렬
    @Query(value = "SELECT * FROM study", nativeQuery = true)
    List<Study> 전체거리순정렬();

    @Query(value = "SELECT * FROM study WHERE interest=?1 ORDER BY createdate desc", nativeQuery = true)
    List<Study> 필터링최신순정렬(String interest);

    @Query(value = "SELECT * FROM study WHERE interest=?1 ORDER BY mood desc", nativeQuery = true)
    List<Study> 필터링추천순정렬(String interest);

    @Query(value = "SELECT * FROM study WHERE interest=?1", nativeQuery = true)
    List<Study> 필터링거리순정렬(String interest);

    List<Study> 스터디생성();

    List<Study> 스터디정보조회();
}
