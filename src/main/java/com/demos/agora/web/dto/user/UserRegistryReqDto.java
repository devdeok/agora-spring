
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
    private String age;
    private String sex;
    private String interest;
//    private LocationReqDto locationReqDto;
    private Double latitude;
    private Double longitude;

    // 객체로 만드는 메서드
    public User toEntity() {
        return User.builder().
                phoneNumber(phoneNumber).
                association(association).
                age(age).
                sex(sex).
                interest(interest).
                build();
    }
}
