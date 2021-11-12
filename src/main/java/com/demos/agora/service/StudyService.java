package com.demos.agora.service;


import com.demos.agora.model.study.Study;
import com.demos.agora.model.study.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;

    @Transactional(readOnly = true)
    public List<Study> 전체스터디목록() {return studyRepository.전체스터디목록();}

}
