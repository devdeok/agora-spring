package com.demos.agora.web.dto.evaluate;

import javax.annotation.Nullable;



public interface EvalRespDto {
    String getEvalType();
    String getTitle();      // 스터디 제목
    int getStudyId();           // 스터디 id
    String getInterest();   // 관심분야
    int getEvaluateeId();         //
    String getEvaluateeNickName();   //
}
