package com.demos.agora.model.study;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;   // 스터디 제목
    private String interest;// 관심분야
    private Date createDate;      // 만든시간
    private int limit;      // 수용인원
    private double latitude;
    private double longitude;
    private double mood;    // 스터디 분위기

  //  private int member;//멤버 수

  //  @ManyToOne // study가 many
  //  @JoinColumn(name = "userId") // 컬럼명 적기
  //  private User user;


}
