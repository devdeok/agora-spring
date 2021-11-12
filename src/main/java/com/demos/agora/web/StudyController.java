package com.demos.agora.web;

import com.demos.agora.model.study.Study;
import com.demos.agora.service.StudyService;
import com.demos.agora.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudyController {
    private final StudyService studyService;

    @GetMapping("/study")
    public CMRespDto<?> 전체스터디목록(String address) {
        return new CMRespDto<>(1, studyService.전체스터디목록());
    }

//    @GetMapping("/study/sortType")
//    public CMRespDto<?> 스터디정렬(String sortType) {
//        return new CMRespDto<>(1, studyService.스터디정렬(sortType));
//    }

    @GetMapping("/study/filter")
    public CMRespDto<?> 스터디필터링(String interest, String lineup) {
        return new CMRespDto<>(1, studyService.스터디필터링(interest,lineup));
    }
}
