package com.demos.agora.model.study;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {

    @Query(value = "SELECT id, interest, title, `date`, `limit` FROM study", nativeQuery = true)
    List<Study> 전체스터디목록();

    @Query(value = "SELECT id, interest, title, `date`, `limit` FROM study WHERE interest=:interest", nativeQuery = true)
    List<Study> 스터디필터링(@Param("interest") String interest);

    // 최근순쿼리
    // 거리순쿼리
    // 추천순쿼리

}
