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

    @Query(value = "SELECT evalType, title AS studyTitle, studyId, f.interest, evaluateeId, nickname AS evaluateeNickname\n" +
            "From(SELECT evalType, title, studyId, interest, evaluateeId\n" +
            "FROM (SELECT 'manner'as evalType, evaluateeId, studyId, evaluation, title, interest\n" +
            "      FROM testdb.manner as a JOIN testdb.study as b ON a.studyId=b.id \n" +
            "      WHERE a.evaluatorId=?1 \n" +
            "      GROUP BY studyId \n" +
            "      HAVING evaluation=1)as d)as f JOIN testdb.user as e ON f.evaluateeId=e.id;", nativeQuery = true)
    List<EvalRespDto> 매너평가항목(int userId);

    // 평가한지 2주이상 된 사용자의 evaluation 상태를 1로 바꾸고 evaluateDate를 현재날짜로 update
    // 하루에 한번씩 스케쥴링을 통해 업데이트됨
    // UPDATE user SET manner=((manner*mannerCount)+?2)/(mannerCount+1), mannerCount=mannerCount+1 WHERE id=?1
    @Modifying
    @Query(value = "UPDATE user " +
                    "SET manner=((manner*mannerCount)+?2)/(mannerCount+1), mannerCount=mannerCount+1 " +
                    "WHERE id=?1",nativeQuery = true)
    int 매너업데이트(int studyId, double mannerAvgScore);
    // UPDATE manner SET evaluateDate=curdate(), evaluation=0 WHERE userId=?2 AND studyId=?1
    @Modifying
    @Query(value = "UPDATE manner " +
                    "SET evaluateDate=curdate(), evaluation=0 " +
                    "WHERE evaluatorId=?2 " +
                        "AND evaluateeId=?3 " +
                        "AND studyId=?1",nativeQuery = true)
    int 매너평가완료(int studyId, int evaluatorId, int evaluateeId);

}
