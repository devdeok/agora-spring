package com.demos.agora.web.dto.study;

import lombok.Data;

import java.sql.Date;

@Data
public class TestDto {
    int studyId;
    int userId;
    int role;
    Date memberSince;
}
