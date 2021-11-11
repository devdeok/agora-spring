package com.demos.agora.model.study;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {


@Query(value = "select id, interest, title, `date`, `limit` from study;", nativeQuery = true)
 List<Study> 전체스터디목록();

}
