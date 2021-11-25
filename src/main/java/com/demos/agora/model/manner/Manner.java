package com.demos.agora.model.manner;

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
public class Manner {
   @EmbeddedId
    private MannerKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="evaluatorId")
    private User mannerEvaluator;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="evaluateeId")
    private User mannerEvaluatee;

    @ManyToOne
    @MapsId("studyId")
    @JoinColumn(name = "studyId")
    private Study mannerStudy;

    private Date evaluateDate;  // 평가한 날짜 (기본값:현재날짜)
    private Boolean evaluation; // 평가 상태 (1:하는중, 0:안함)

    // studyId : 평가가 진행된 studyId
    // evaluatorId : 평가하는 userId
    // evaluateeId : 평가받는 userId
    // evaluateDate : 평가가 진행된 날짜 (기본값으로 현재 날짜가 들어감)
    // 점수 (안드로이드에서 항목별 점수를 계산해서 모두 더한 다음 항목수만큼 나누어 보내줌)
}
