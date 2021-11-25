package com.demos.agora.model.mood;

import com.demos.agora.model.study.Study;
import com.demos.agora.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Mood {
    @EmbeddedId
    private MoodKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="userId")
    private User moodEvaluator;          // 평가하는 사용자

    @ManyToOne
    @MapsId("studyId")
    @JoinColumn(name="studyId")
    private Study moodStudy;        // 평가받는 스터디

    private Date evaluateDate;  // 평가한 날짜 (기본값:현재날짜)
    private Boolean evaluation; // 평가 상태 (1:하는중, 0:안함)


}
