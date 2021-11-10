package com.demos.agora.web;

import com.demos.agora.service.StudyService;
import com.demos.agora.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StudyController {

    private final StudyService studyService;

    @GetMapping("/study")
    public CMRespDto<?> 전체스터디목록(String address) {
        return new CMRespDto<>(1, studyService.전체스터디목록());
    }

}
