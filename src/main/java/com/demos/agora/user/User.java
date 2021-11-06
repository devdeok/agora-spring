package com.demos.agora.user;

import lombok.Data;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id @Column(name = "user_id")
    // SQL 에서 자동생성되도록 돕는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String association;//소속
    private String age;//나이
    private String sex;//성별
    private String interest;//관심분야

    @Builder
    public User(String association, String age, String sex, String interest) {
        this.association = association;
        this.age = age;
        this.sex = sex;
        this.interest = interest;
    }

}
