package com.demos.agora.model.user;

import com.demos.agora.model.join.Join;
import com.demos.agora.model.manner.Manner;
import com.demos.agora.model.mood.Mood;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // @Column(name = "user_id")
    // SQL 에서 자동생성되도록 돕는 어노테이션
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable =false ,length = 50,unique=true) //  nullable : null 허용 x , length : 글자길이 , unique : 중복허용 x
    private String nickName;

    private String association; //소속
    private String age;         //나이
    private String sex;         //성별
    private String interest;    //관심분야
    private String phoneNumber; //핸드폰번호
    private double latitude;
    private double longitude;

    @CreationTimestamp
    private Timestamp createDate;

    // join table에 있는 user에 mapping
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    Set<Join> join;

    @JsonIgnore
    @OneToMany(mappedBy = "moodEvaluator")
    Set<Mood> mood;

    @JsonIgnore
    @OneToMany(mappedBy = "mannerEvaluator")
    Set<Manner> mannerEvaluator;

    @JsonIgnore
    @OneToMany(mappedBy = "mannerEvaluatee")
    Set<Manner> mannerEvaluatee;

}

