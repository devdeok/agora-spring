package com.demos.agora.schedule;

import com.demos.agora.model.manner.MannerRepository;
import com.demos.agora.model.mood.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EvaluateScheduler {
    // 데이터베이스에서 하루에 한번씩 평가한지 2주된 사용자의 evaluation 상태를 업데이트
    @Autowired
    private MoodRepository moodRepository;
    @Autowired
    private MannerRepository mannerRepository;

    // cron = 초 분 시 일 월 요일
    @Scheduled(cron = "0 0 0 * * *") // 매일 0시 마다
    public void evaluateScheduling(){
        // evaluation 및 evaluateDate 업데이트
        moodRepository.분위기평가여부설정();
        mannerRepository.매너평가여부설정();
    }
}
