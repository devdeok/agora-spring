package com.demos.agora.model.study;

import com.demos.agora.web.dto.study.StudyListResDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {

    @Query(value = "SELECT * FROM (SELECT id,title,interest,createDate,`limit`,COUNT(userId) AS `current`,ST_DISTANCE_SPHERE(POINT(?2, ?1), location) AS distance\n" +
            "FROM testdb.study as s\n" +
            "JOIN testdb.`join` as j\n" +
            "ON s.id = j.studyId\n" +
            "GROUP BY studyId\n" +
            "HAVING `current` >= 1\n" +
            "ORDER BY createDate desc) AS a WHERE a.distance<10000;", nativeQuery = true)
    List<StudyListResDto> 전체최신순정렬(double latitude, double longitude);

    @Query(value = "SELECT * FROM (SELECT id,title,interest,createDate,`limit`,COUNT(userId) AS `current`,ST_DISTANCE_SPHERE(POINT(?2, ?1), location) AS distance\n" +
            "FROM testdb.study as s\n" +
            "JOIN testdb.`join` as j\n" +
            "ON s.id = j.studyId\n" +
            "GROUP BY studyId\n" +
            "HAVING `current` >= 1\n" +
            "ORDER BY mood desc) AS a WHERE a.distance<10000;", nativeQuery = true)
    List<StudyListResDto> 전체추천순정렬(double latitude, double longitude);

    @Query(value = "SELECT * FROM (SELECT id,title,interest,createDate,`limit`,COUNT(userId) AS `current`,ST_DISTANCE_SPHERE(POINT(?2, ?1), location) AS distance\n" +
            "FROM testdb.study as s\n" +
            "JOIN testdb.`join` as j\n" +
            "ON s.id = j.studyId\n" +
            "GROUP BY studyId\n" +
            "HAVING `current` >= 1\n" +
            "ORDER BY distance) AS a WHERE a.distance<10000;", nativeQuery = true)
    List<StudyListResDto> 전체거리순정렬(double latitude, double longitude);

    @Query(value = "SELECT * FROM (SELECT id,title,interest,createDate,`limit`,COUNT(userId) AS `current`,ST_DISTANCE_SPHERE(POINT(?2, ?1), location) AS distance\n" +
            "FROM testdb.study as s\n" +
            "JOIN testdb.`join` as j\n" +
            "ON s.id = j.studyId\n" +
            "GROUP BY studyId\n" +
            "HAVING `current` >= 1\n" +
            "ORDER BY createDate desc) AS a WHERE a.distance<10000 AND interest='?3';", nativeQuery = true)
    List<StudyListResDto> 필터링최신순정렬(double latitude, double longitude, String interest);

    @Query(value = "SELECT * FROM (SELECT id,title,interest,createDate,`limit`,COUNT(userId) AS `current`,ST_DISTANCE_SPHERE(POINT(?2, ?1), location) AS distance\n" +
            "FROM testdb.study as s\n" +
            "JOIN testdb.`join` as j\n" +
            "ON s.id = j.studyId\n" +
            "GROUP BY studyId\n" +
            "HAVING `current` >= 1\n" +
            "ORDER BY mood desc) AS a WHERE a.distance<10000 AND interest='?3';", nativeQuery = true)
    List<StudyListResDto> 필터링추천순정렬(double latitude, double longitude, String interest);

    @Query(value = "SELECT * FROM (SELECT id,title,interest,createDate,`limit`,COUNT(userId) AS `current`,ST_DISTANCE_SPHERE(POINT(?2, ?1), location) AS distance\n" +
            "FROM testdb.study as s\n" +
            "JOIN testdb.`join` as j\n" +
            "ON s.id = j.studyId\n" +
            "GROUP BY studyId\n" +
            "HAVING `current` >= 1\n" +
            "ORDER BY distance) AS a WHERE a.distance<10000 AND interest='?3';", nativeQuery = true)
    List<StudyListResDto> 필터링거리순정렬(double latitude, double longitude, String interest);

    @Query(value = "INSERT INTO study(title,interest,createdate,`limit`,count,latitude,longitude,location,`description`)" +
                   " VALUES(:title,:interest,CURDATE(),:limit,:count,:latitude,:longitude," +
                   "(ST_GeomFromText('POINT(:longitude :latitude)')),:description)",nativeQuery = true)
    List<Study> 스터디생성(@Param("title") String title,
                        @Param("interest") String interest,
                        @Param("limit") int limit,
                        @Param("count") int count,
                        @Param("longitude") Double longitude,
                        @Param("latitude") Double latitude,
                        @Param("description") String description);


  //  List<Study> 스터디정보조회(long studyId);
}
