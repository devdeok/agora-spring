package com.demos.agora.service;

import com.demos.agora.model.study.Study;
import com.demos.agora.model.study.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;

    @Transactional(readOnly = true)
    public List<Study> 전체스터디목록() {return studyRepository.전체스터디목록();}

    @Transactional(readOnly = true)
    public List<Study> 스터디필터링(String interest, String lineup) {
        if(lineup=="거리순"){

        }else if(lineup=="최근순"){

        }else if(lineup=="추천순"){

        }
//        return studyRepository.스터디필터링(interest);
        return studyRepository.전체스터디목록();
    }

}
