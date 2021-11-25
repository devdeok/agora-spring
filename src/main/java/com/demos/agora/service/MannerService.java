package com.demos.agora.service;

import com.demos.agora.model.manner.MannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MannerService {
    private final MannerRepository mannerRepository;

    @Transactional// postmapping
    public int 스터디매너평가(){
        return mannerRepository.스터디매너평가();
    }
    
    /*
    * 스터디 가입날짜와 현재날짜를 주기적으로 비교하여 2주가 되었을 경우
    * client로 스터디 평가를 진행해야 된다는 알림을 보내는 서비스 필요
    * @Scheduled라는 어노테이션을 사용하여 DB에서 하루에 한번씩 계산
    * 설문 끝나면 delete하기
    * */
    
}
