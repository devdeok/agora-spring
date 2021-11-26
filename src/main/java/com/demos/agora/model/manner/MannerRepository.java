package com.demos.agora.model.manner;

import com.demos.agora.web.dto.evaluate.EvalRespDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MannerRepository extends JpaRepository<Manner, Long> {


    @Modifying
    @Transactional
    @Query(value = "UPDATE manner_evaluation " +
            "SET evaluation = 1" +
            "WHERE TIMESTAMPDIFF(day,evaluateDate,CURDATE())>=14 " +
            "AND evaluation=0",nativeQuery = true)
    int 매너평가여부설정();

    @Query(value = "SELECT evalType, title, studyId, f.interest, evaluateeId, nickname as evaluateeNickname\n" +
            "From(SELECT evalType, title, studyId, interest, evaluateeId\n" +
            "FROM (SELECT 'manner'as evalType, evaluateeId, studyId, evaluation, title, interest\n" +
            "      FROM testdb.manner as a JOIN testdb.study as b ON a.studyId=b.id \n" +
            "      WHERE a.evaluatorId=?1 \n" +
            "      GROUP BY studyId \n" +
            "      HAVING evaluation=1)as d)as f JOIN testdb.user as e ON f.evaluateeId=e.id;", nativeQuery = true)
    List<EvalRespDto> 평가해야할매너(int userId);

}
