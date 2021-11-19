package com.demos.agora.model.study;

import com.demos.agora.model.join.Join;
import com.demos.agora.model.user.User;
import lombok.*;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;   // 스터디 제목
    private String interest;// 관심분야
    private Date createDate;      // 만든시간
    private int limit;      // 수용인원
    private int count;      // 스터디 주 x회
    private double latitude;
    private double longitude;
    private Point location; // Point(longitude, latitude)
    private double mood;    // 스터디 분위기
    private String description; // 스터디 설명

    // join table에 있는 study와 mapping
    @OneToMany(mappedBy = "study")
    Set<Join> join;

}
