package com.demos.agora.web.dto.study;

import lombok.Data;

@Data
public class StudyListReqDto {
    // 정렬시 필요한 사용자의 휴대폰번호, 관심분야, 정렬방법
    private String phoneNumber; // 사용자 핸드폰번호
    private String interest;    // 관심분야
    private String lineup;      // 최근순, 거리순, 추천순
}
