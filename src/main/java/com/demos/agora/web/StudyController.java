package com.demos.agora.web;

import com.demos.agora.service.StudyService;
import com.demos.agora.web.dto.CMRespDto;
import com.demos.agora.web.dto.study.StudyCreateReqDto;
import com.demos.agora.web.dto.study.StudyListReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class StudyController {
    private final StudyService studyService;

    @GetMapping("/study/list")
    public CMRespDto<?> 스터디목록(String phoneNumber,  String interest, String lineup) {
        return new CMRespDto<>(1, studyService.스터디정렬(phoneNumber, interest, lineup));
    }

    @PostMapping("/study/create")
    public CMRespDto<?> 스터디생성(@RequestBody StudyCreateReqDto studyCreateReqDto){
        return new CMRespDto<>(1,  studyService.스터디생성(studyCreateReqDto));
    }

    @GetMapping("/study/detail")
    public CMRespDto<?> 스터디정보조회(){
        return new CMRespDto<>(1, studyService.스터디정보조회());
    }


    /* @GetMapping("/study")
        public CMRespDto<?> 전체스터디목록() {
            return new CMRespDto<>(1, studyService.전체스터디목록());
        }*/

//    @GetMapping("/study/sortType")
//    public CMRespDto<?> 스터디정렬(String sortType) {
//        return new CMRespDto<>(1, studyService.스터디정렬(sortType));
//    }

   /* @GetMapping("/study/filter")
    public CMRespDto<?> 스터디필터링(String interest, String lineup) {
        return new CMRespDto<>(1, studyService.스터디필터링(interest,lineup));
    }*/
}
