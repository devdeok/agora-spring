package com.demos.agora.web.dto.auth;

import lombok.Data;

@Data
public class AuthUpdateReqDto {
    private String phoneNumber;
    private String authCode;
}
