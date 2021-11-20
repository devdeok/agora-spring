package com.demos.agora.service;

import static org.junit.Assert.assertNotNull;

import com.demos.agora.model.location.GeometryUtil;
import com.demos.agora.model.study.Study;
import com.demos.agora.model.study.StudyRepository;
import com.demos.agora.web.dto.study.StudyCreateReqDto;

import com.demos.agora.web.dto.study.StudyDetailRespDto;

import com.demos.agora.web.dto.study.StudyListRespDto;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyService {
    private final StudyRepository studyRepository;

    // 정렬 시 study와 user가 매핑된 table도 join해서 데이터를 response해주어야 함
    @Transactional(readOnly = true)
    public List<StudyListRespDto> 스터디목록(double latitude, double longitude, String interest, String lineup) {

        if (interest.equals("전체")) {
            if (lineup.equals("최신순"))
                return studyRepository.전체최신순정렬(latitude, longitude);
            else if (lineup.equals("추천순"))
                return studyRepository.전체추천순정렬(latitude, longitude);
            else//거리순 정렬
                return studyRepository.전체거리순정렬(latitude, longitude);
        }
        else { // 필터링
            if (lineup.equals("최신순"))
                return studyRepository.필터링최신순정렬(latitude, longitude, interest);
            else if (lineup.equals("추천순"))
                return studyRepository.필터링추천순정렬(latitude, longitude, interest);
            else//거리순 정렬
                return studyRepository.필터링거리순정렬(latitude, longitude, interest);
        }
    }

    // 생성 시 study_user테이블에 study와 user의 id를 매핑시켜 주어야 하며 생성한 user에게 그룹장 권한을 부여해야 한다.
    @Transactional
    public int 스터디생성(StudyCreateReqDto studyCreateReqDto) {
        // 스터디 생성 후에는 생성된 studyId, userId가 필요하며 userId에는 그룹장 권한을 주어야 한다.
        String title = studyCreateReqDto.getTitle();
        String interest = studyCreateReqDto.getInterest();
        int limit = studyCreateReqDto.getLimit();//여기에 값이 안들어옴 숫자로만 받을 수 있게 해야할 듯?
        int count = studyCreateReqDto.getCount();

        double longitude = studyCreateReqDto.getLongitude();
        double latitude = studyCreateReqDto.getLatitude();

        //
        String locationWKT = "POINT("+new Double(longitude).toString()+" "+new Double(latitude).toString()+")";
        Geometry GeoPoint = GeometryUtil.wktToGeometry(locationWKT);

        assertNotNull(GeoPoint);

        Study studyLocation = new Study();
        studyLocation.setLocation((Point)GeoPoint);

        String location = studyLocation.getLocation().toString();

        longitude = Math.round(longitude*1000000)/1000000.0; // 소수점 6자리까지 맞춤
        latitude = Math.round(latitude*1000000)/1000000.0;

        String description = studyCreateReqDto.getDescription();

        return studyRepository.스터디생성(title, interest, limit, count,
                longitude, latitude, location, description); // error
    }


    @Transactional(readOnly = true)
    public List<StudyDetailRespDto> 스터디정보조회(Long studyId){
        return studyRepository.스터디정보조회(studyId);
    }

}







