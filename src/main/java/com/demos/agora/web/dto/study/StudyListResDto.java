package com.demos.agora.web.dto.study;

import java.sql.Date;

public interface StudyListResDto {
    long getId();
    String getTitle();   // 스터디 제목
    String getInterest();// 관심분야
    Date getCreateDate();      // 만든시간
    int getLimit();      // 수용인원
    int getCurrent();//멤버 수
    double getDistance();//유저와의 거리

}
