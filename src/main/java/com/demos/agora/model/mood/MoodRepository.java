package com.demos.agora.model.mood;

import com.demos.agora.web.dto.evaluate.EvalRespDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MoodRepository extends JpaRepository<Mood,Long> {

    // 평가한지 2주이상 된 사용자의 evaluation 상태를 1로 바꾸고 evaluateDate를 현재날짜로 update
    // 하루에 한번씩 스케쥴링을 통해 업데이트됨
    @Modifying
    @Transactional
    @Query(value = "UPDATE mood_evaluation " +
                    "SET evaluation = 1" +
                    "WHERE TIMESTAMPDIFF(day,evaluateDate,CURDATE())>=14 " +
                    "AND evaluation=0",nativeQuery = true)
    int 분위기평가여부설정();

    // evaluate가 1인 사용자의 목록을 보여줌

    @Query(value = "SELECT evalType, title as studyTitle, studyId, interest, evaluateeId, evaluateeNickname\n" +
            "FROM (SELECT 'mood'as evalType, 0 as evaluateeId, 'no'as evaluateeNickname, studyId, evaluation, title, interest\n" +
            "      FROM testdb.mood as a JOIN testdb.study as b ON a.studyId=b.id \n" +
            "      WHERE a.userId=?1 \n" +
            "      GROUP BY studyId \n" +
            "      HAVING evaluation=1)as d;", nativeQuery = true)
    List<EvalRespDto> 분위기평가항목(int userId);

    @Modifying
    @Transactional//이거 있어야 쿼리가 정상적으로 실행되요!
    @Query(value = "UPDATE study SET mood=((mood*moodCount)+?2)/(moodCount+1), moodCount=moodCount+1 WHERE id=?1",nativeQuery = true)
    int 분위기업데이트(int studyId, Double moodAvgScore);

    @Modifying
    @Transactional
    @Query(value = "UPDATE mood SET evaluateDate=curdate(), evaluation=0 WHERE userId=?2 AND studyId=?1",nativeQuery = true)
    int 분위기평가완료(int studyId, int userId);

}
