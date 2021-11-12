package com.demos.agora.web.dto.user;

import com.demos.agora.model.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegistryReqDto {
    private String phoneNumber;
    private String association;
    private String sex;
    private String age;
    private String interest;

    public User toEntity() {
        return User.builder().
                phoneNumber(phoneNumber).
                association(association).
                sex(sex).
                age(age).
                interest(interest).build();
    }
}
