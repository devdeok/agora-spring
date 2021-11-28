package com.demos.agora.web;

import com.demos.agora.service.EvaluateService;
import com.demos.agora.service.StudyService;
import com.demos.agora.web.dto.CMRespDto;
import com.demos.agora.web.dto.evaluate.EvalReqDto;
import com.demos.agora.web.dto.evaluate.MoodReqDto;
import com.demos.agora.web.dto.study.StudyCreateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EvaluateController {
    private final EvaluateService evaluateService;

    /*
    ///////Dto로 받음
    @GetMapping("/evaluate")
    public CMRespDto<?> 평가리스트(EvalReqDto evalReqDto) {
        return new CMRespDto<>(1, evaluateService.평가해야할목록(evalReqDto));
    }
    */

    @GetMapping("/evaluate")
    public CMRespDto<?> 평가리스트(int userId) {
        return new CMRespDto<>(1, evaluateService.평가목록(userId));
    }

   /*
   /////////Dto로 받음
   @PostMapping("/evaluate/mood")
    public CMRespDto<?> 스터디생성(MoodReqDto moodReqDto){
        // client에서 userId를 가지고 있어야하며 request DTO로 넘겨주어야 함
        // server는 studyId를 넘겨주어야 함(알아서 해줌)
        // 각 목록의 item들은 studyId를 가지고 있어야 함
        return new CMRespDto<>(1,  evaluateService.분위기업데이트(moodReqDto));
    }*/

    @PostMapping("/evaluate/mood")
    public CMRespDto<?> 분위기업데이트(int studyId, int userId, double moodAvgScore){
        // client에서 userId를 가지고 있어야하며 request DTO로 넘겨주어야 함
        // server는 studyId를 넘겨주어야 함(알아서 해줌)
        // 각 목록의 item들은 studyId를 가지고 있어야 함
        return new CMRespDto<>(1,  evaluateService.분위기업데이트(studyId, userId, moodAvgScore));
    }

    @PostMapping("/evaluate/manner")
    public CMRespDto<?> 매너업데이트(int studyId, int evaluatorId, int evaluateeId, double mannerAvgScore){
        // client에서 userId를 가지고 있어야하며 request DTO로 넘겨주어야 함
        // server는 studyId를 넘겨주어야 함(알아서 해줌)
        // 각 목록의 item들은 studyId를 가지고 있어야 함
        return new CMRespDto<>(1,  evaluateService.매너업데이트(studyId, evaluatorId, evaluateeId, mannerAvgScore));
    }
}
