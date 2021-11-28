package com.demos.agora.web.dto.evaluate;

import lombok.Data;

@Data
public class MannerReqDto {
    private int evaluatorId;// 평가하는 사람
    private int evaluateeId;// 평가 받는 사람
    private double mannerAvgScore; // 평가 점수
}
