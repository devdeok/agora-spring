package com.demos.agora.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Location {
    private String sggcode;     // 1. 시군구코드
    private String entrancecode;// 2. 출입구일련번호
    private String bjdcode;     // 3. 법정도코드
    private String sdm;         // 4. 시도명
    private String sggm;        // 5. 시군구명
    private String omdm;        // 6. 읍면동명

    @Id
    private String drmcode;     // 7. 도로명코드

    private String drm;         // 8. 도로명
    private String jhyb;        // 9. 지하여부
    private int buildbb;        // 10. 건물본번
    private int buildboob;      // 11. 건문부번
    private String buildname;   // 12. 건물명
    private String paxnum;         // 13. 우편번호
    private String buildboonryu;// 14. 건물용도분류
    private String buildyb;     // 15. 건물군여부

    @Column(unique=true)
    private String ghhjd;       // 16. 관할행정동
    private double entX;        // 17. X좌표
    private double entY;        // 18. Y좌표
}
