package com.demos.agora.service;

import com.demos.agora.model.study.Study;
import com.demos.agora.model.study.StudyRepository;
import com.demos.agora.model.user.User;
import com.demos.agora.model.user.UserRepository;
import com.demos.agora.web.dto.location.LocationReqDto;
import com.demos.agora.web.dto.study.StudyListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;
<<<<<<< HEAD
    private final UserRepository userRepository;

   // @Transactional(readOnly = true)
    private List<Study> 필터링된스터디목록(String interest, String order) {

   //     List<Study> return_study=new ArrayList<>();
        if (interest.equals("전체")) {
            if (order.equals("최신순")) {
         //       for(Study study:studyRepository.전체최신순정렬())
         //       {
         //           return_study.add(study);
         //       }
         //       return return_study;
                return studyRepository.전체최신순정렬();
            }
            else if (order.equals("추천순"))
                return studyRepository.전체추천순정렬();
            else//거리순 정렬
                return studyRepository.전체거리순정렬();

        } else {
            if (order.equals("최신순"))
                return studyRepository.필터링최신순정렬(interest);
            else if (order.equals("추천순"))
                return studyRepository.필터링추천순정렬(interest);
            else//거리순 정렬
                return studyRepository.필터링거리순정렬(interest);
        }
    }
=======
    private final DistanceCalc distanceCalc = new DistanceCalc();
    
    // 사용자와 스터디간의 거리 차이도 표시해주어야함
    @Transactional(readOnly = true)
    public List<Study> 전체스터디목록() {
        

        return studyRepository.전체스터디목록();}
>>>>>>> 740ec635e32c5b93168209f85a4383193607d2c8

    @Transactional(readOnly = true)
    public  List<StudyListDto> 가까운스터디목록(String phoneNumber, String interest, String order){
        User userLocation=userRepository.m유저설정위치(phoneNumber);//유저 위치 DB에서 빼옴(폰번호로 mapping)

        //전체스터디 목록 list를 하나씩 확인하며 위도경도로 되어있는걸 유저와의 거리로 계산해 StudyListDto list로 바꿈

        List<Study> filtered_study=new ArrayList<>();


        for(Study study:필터링된스터디목록(interest, order))
        {
            filtered_study.add(study);
        }
      //  List<Study> filtered_study=필터링된스터디목록(interest, order);//쿼리문으로 인해 필터링,정렬된 스터디 목록들을 리스트에 담음(하니씩 살펴보기 위해)



        List<StudyListDto> studyList = new ArrayList<>();//사용자와의 거리를 계산 한 후 담음

        double distance;
        for(Study study : filtered_study)
        {
            distance=DistanceService.distance(study.getEntX(), study.getEntY(), userLocation.getLatitude(), userLocation.getLongitude());
            studyList.add(new StudyListDto(study.getId(),study.getInterest(),study.getTitle(),study.getDate(),study.getLimit(), study.getMood(), distance));
        }


        //StudyListDto list를 하나씩 확인하며 distance가 10키로 이내인것만 새로운 리스트에 담아 return함
        List<StudyListDto> nearStudyList=new ArrayList<>();
        for(StudyListDto studyListDto:studyList)
        {
            if(studyListDto.getDistance()<=10)
                nearStudyList.add(studyListDto);
        }

      /*  if(order.equals("거리순"))
        {
           List<StudyListDto> newNearStudyList= new ArrayList<>();
           Arrays.sort(newNearStudyList,new DistanceComparator());
           return newNearStudyList;
        }*/
        return nearStudyList;
    }

  /*  @Transactional(readOnly = true)
    public List<Study> 스터디필터링(String interest, String lineup) {
        if(lineup=="거리순"){

        }else if(lineup=="최근순"){

        }else if(lineup=="추천순"){

        }
//        return studyRepository.스터디필터링(interest);
        return studyRepository.전체스터디목록();
    }*/

}
