package com.demos.agora.model.study;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String interest;

    private String title;

    private Date date; // 만든시간

    private int limit;

//    private double  latitude;
//    private double longitude;

  //  private double distance;

  //  private int member;//멤버 수

  //  @ManyToOne // study가 many
  //  @JoinColumn(name = "userId") // 컬럼명 적기
  //  private User user;


}
