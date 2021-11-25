package com.demos.agora.model.mood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface MoodRepository extends JpaRepository<Mood,Long> {

    // 평가한지 2주이상 된 사용자의 evaluation 상태를 1로 바꾸고 evaluateDate를 현재날짜로 update
    // 하루에 한번씩 스케쥴링을 통해 업데이트됨
    @Modifying
    @Transactional
    @Query(value = "UPDATE mood_evaluation " +
                    "SET evaluation = 1," +
                    "evaluateDate = CURDATE() " +
                    "WHERE TIMESTAMPDIFF(day,evaluateDate,CURDATE())>=14 " +
                    "AND evaluation=0",nativeQuery = true)
    int 분위기평가날짜();

    // evaluate가 1인 사용자의 목록을 보여줌

}
