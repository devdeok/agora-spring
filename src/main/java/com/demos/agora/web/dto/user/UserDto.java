package com.demos.agora.web.dto.user;

import com.demos.agora.model.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String association;//소속
    private String age;//나이
    private String sex;//성별
    private String interest;//관심분야

    @Builder
    public UserDto(Long id, String association, String age, String sex, String interest) {
        this.id = id;
        this.association = association;
        this.age = age;
        this.sex = sex;
        this.interest = interest;
    }

//    public User toEntity(){
//        return User.builder()
//                .association(association)
//                .age(age)
//                .sex(sex)
//                .interest(interest)
//                .build();
//    }
}
