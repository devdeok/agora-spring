package com.demos.agora.model.user;

import com.demos.agora.model.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

//    @Column(name = "user_id")
    // SQL 에서 자동생성되도록 돕는 어노테이션
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private String association;//소속
//    private String age;//나이
//    private String sex;//성별
//    private String interest;//관심분야

    private String phoneNumber;

    @Column(nullable =false ,length = 50,unique=true)  //  nullable : null 허용 x , length : 글자길이 , unique : 중복허용 x
    private String nickName;

    private String photo;

//    @Builder
//    public User(String association, String age, String sex, String interest) {
//        this.association = association;
//        this.age = age;
//        this.sex = sex;
//        this.interest = interest;
//    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // cacade : post 삭제시 이미지 다날라감.
    @JsonIgnoreProperties({"user"})
    @ToString.Exclude
    private List<Post> posts;

    @CreationTimestamp
    private Timestamp createDate;
}
