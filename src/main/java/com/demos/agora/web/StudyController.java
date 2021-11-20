package com.demos.agora.web;

import com.demos.agora.service.StudyService;
import com.demos.agora.web.dto.CMRespDto;
import com.demos.agora.web.dto.study.StudyCreateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class StudyController {
    private final StudyService studyService;

    @GetMapping("/study/list")
        public CMRespDto<?> 스터디목록(double latitude, double longitude, String interest, String lineup) {
        return new CMRespDto<>(1, studyService.스터디목록(latitude, longitude, interest, lineup));
    }

    @PostMapping("/study/create")
    public CMRespDto<?> 스터디생성(@RequestBody StudyCreateReqDto studyCreateReqDto){
        // client에서 userId를 가지고 있어야하며 request DTO로 넘겨주어야 함
        // server는 studyId를 넘겨주어야 함(알아서 해줌)
        // 각 목록의 item들은 studyId를 가지고 있어야 함
        return new CMRespDto<>(1,  studyService.스터디생성(studyCreateReqDto));
    }

    @GetMapping("/study/detail/{studyId}")
    public CMRespDto<?> 스터디정보조회(@PathVariable("studyId") Long studyId) {
        // 사용자가 스터디에 가입되었는지 체크한 뒤 client에서 체크해줌
        // 가입되지 않은 사용자일 경우 이 controller로 오게 됨
        // study는 interest, title, limit, description, count을 intent를 통해 들고 있기
        // studyId로 불러올 데이터는 jointable에 매핑된 
        // user의 nickName, role, manner, association
        return new CMRespDto<>(1,  studyService.스터디정보조회(studyId));
    }

}
