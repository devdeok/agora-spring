package com.demos.agora.model.study;

import lombok.*;
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
    private int id;

    private String interest;

    private String title;

    private Date date; // 만든시간

    private int limit;

    private double mood;//스터디 분위기

    private double  entX;
    private double entY;

    public int getId() {
        return id;
    }

    public String getInterest() {
        return interest;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public int getLimit() {
        return limit;
    }

    public double getMood() {
        return mood;
    }

    public double getEntX() {
        return entX;
    }

    public double getEntY() {
        return entY;
    }
//  private double distance;

  //  private int member;//멤버 수

  //  @ManyToOne // study가 many
  //  @JoinColumn(name = "userId") // 컬럼명 적기
  //  private User user;


}
