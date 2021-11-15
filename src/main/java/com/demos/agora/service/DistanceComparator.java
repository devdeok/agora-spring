package com.demos.agora.service;

import com.demos.agora.web.dto.study.StudyListDto;

import java.util.Comparator;

public class DistanceComparator implements Comparator<StudyListDto> {

    @Override
    public int compare(StudyListDto s1, StudyListDto s2) {

        if (s1.getDistance() == s2.getDistance())
            return 0;
        else if (s1.getDistance() > s2.getDistance()) return 1;
        else return -1;
    }
}
