package com.demos.agora.web;

import com.demos.agora.service.EvaluateService;
import com.demos.agora.service.StudyService;
import com.demos.agora.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EvaluateController {
    private final EvaluateService evaluateService;

    @GetMapping("/evaluate")
    public CMRespDto<?> 평가리스트(int userId) {
        return new CMRespDto<>(1, evaluateService.평가해야할목록(userId));
    }

}
