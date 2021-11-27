package com.demos.agora.web.dto.evaluate;

import lombok.Data;

@Data
public class MoodReqDto {
    private int studyId;
    private int userId;
    private double moodAvgScore;
}
