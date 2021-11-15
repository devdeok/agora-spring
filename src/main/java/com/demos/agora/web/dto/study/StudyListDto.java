package com.demos.agora.web.dto.study;

import com.demos.agora.model.auth.Auth;
import com.demos.agora.model.study.Study;
import lombok.Data;

import java.util.Date;

@Data
public class StudyListDto {

    private int id;

    private String interest;

    private String title;

    private Date date; // 만든시간

    private int limit;

    private double mood;//스터디 분위기

    private double distance; //사용자와의 거리

    public StudyListDto(int id, String interest, String title, Date date, int limit, double mood, double distance) {
        this.id = id;
        this.interest = interest;
        this.title = title;
        this.date = date;
        this.limit = limit;
        this.mood = mood;
        this.distance = distance;
    }


    //객체가 되어야 하나...?
}
