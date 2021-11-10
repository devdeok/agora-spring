
package com.demos.agora.web.dto.auth;

import com.demos.agora.model.auth.Auth;
import lombok.Data;

@Data
public class AuthSaveReqDto {
    private String phoneNumber;
    private String authCode;

    public Auth toEntity(){
        return Auth.builder()
                .phoneNumber(phoneNumber)
                .authCode(authCode)
                .build();
    }
}

