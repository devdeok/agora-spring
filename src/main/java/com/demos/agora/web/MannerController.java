package com.demos.agora.web;

import com.demos.agora.service.MannerService;
import com.demos.agora.service.StudyService;
import com.demos.agora.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MannerController {
    private final MannerService mannerService;
    private final StudyService studyService;

    @PostMapping("/study/manner")
    public CMRespDto<?> 스터디매너평가(){
        return new CMRespDto<>(1, mannerService.스터디매너평가());
    }
}
