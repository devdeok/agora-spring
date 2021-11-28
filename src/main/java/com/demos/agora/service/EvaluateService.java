package com.demos.agora.service;

import com.demos.agora.model.manner.MannerRepository;
import com.demos.agora.model.mood.MoodRepository;
import com.demos.agora.web.dto.evaluate.EvalReqDto;
import com.demos.agora.web.dto.evaluate.EvalRespDto;
import com.demos.agora.web.dto.evaluate.MoodReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluateService {
    private final MoodRepository moodRepository;
    private final MannerRepository mannerRepository;

/*
    @Transactional(readOnly = true)
    public List<EvalRespDto> 평가해야할목록(EvalReqDto evalReqDto){

        int userId=evalReqDto.getUserId();

        List<EvalRespDto> mood=new ArrayList<>( moodRepository.평가해야할분위기(userId));
        List<EvalRespDto> manner=new ArrayList<>(mannerRepository.평가해야할매너(userId));
        List<EvalRespDto> list=new ArrayList<>();

        list.addAll(mood);
        list.addAll(manner);

        return list;
    }
   */

    @Transactional(readOnly = true)
    public List<EvalRespDto> 평가목록(int userId){
        System.out.println("@@@@@@@@@@@@@@@@@@@@"+userId+"@@@@@@@@@@@@@@@@@@@@");
        List<EvalRespDto> mood=new ArrayList<>( moodRepository.분위기평가항목(userId));
        List<EvalRespDto> manner=new ArrayList<>(mannerRepository.매너평가항목(userId));
        List<EvalRespDto> list=new ArrayList<>();

        list.addAll(mood);
        list.addAll(manner);

        return list;
    }

   /* @Transactional(readOnly = false)
    public List<Integer> 분위기업데이트(MoodReqDto moodReqDto){
       int studyId = moodReqDto.getStudyId();
       int userId = moodReqDto.getUserId();
       Double moodAvgScore = moodReqDto.getMoodAvgScore();

       List<Integer> update = new ArrayList<>();

       update.add(moodRepository.분위기업데이트(studyId, moodAvgScore));
       update.add(moodRepository.분위기평가완료(studyId, userId));

       return update;
    }*/


   @Transactional
   public List<Integer> 분위기업데이트(int studyId, int userId, double moodAvgScore){

       List<Integer> update = new ArrayList<>();

       update.add(moodRepository.분위기업데이트(studyId, moodAvgScore));
       update.add(moodRepository.분위기평가완료(studyId, userId));

       return update;
   }

    @Transactional
    public List<Integer> 매너업데이트(int studyId, int evaluatorId, int evaluateeId, double mannerAvgScore){

        List<Integer> update = new ArrayList<>();

        // 사용자의 매너 점수 및 매너평가된 횟수(+1)를 업데이트해줌
        update.add(mannerRepository.매너업데이트(studyId, mannerAvgScore));
        // manner table의 평가날짜를 현재 날짜로 업데이트, evaluatio은 0으로 세팅
        update.add(mannerRepository.매너평가완료(studyId, evaluatorId, evaluateeId));

        return update;
    }


    /* @Transactional(readOnly = true)
    public List<EvalRespDto> 평가해야할분위기(int userId){
        return moodRepository.평가해야할분위기(userId);
    }

    @Transactional(readOnly = true)
    public List<EvalRespDto> 평가해야할매너(int userId){
        return mannerRepository.평가해야할매너(userId);
    }*/



    /*
    * 스터디 가입날짜와 현재날짜를 주기적으로 비교하여 2주가 되었을 경우
    * client로 스터디 평가를 진행해야 된다는 알림을 보내는 서비스 필요
    * @Scheduled라는 어노테이션을 사용하여 DB에서 하루에 한번씩 계산
    * 설문 끝나면 delete하기
    * */
    
}
