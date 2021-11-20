package com.demos.agora.web.dto.study;

import lombok.Data;

@Data
public class StudyCreateReqDto {
    private String title;    // 스터디 제목
    private String interest; // 관심분야
    private int count;  // 횟수 주 x회
    private int limit;  // 최대 인원
    private double longitude;
    private double latitude;
    private String description;
}
