
package com.demos.agora.web;

import com.demos.agora.service.AuthService;
import com.demos.agora.web.dto.CMRespDto;
import com.demos.agora.web.dto.auth.AuthSaveReqDto;
import com.demos.agora.web.dto.auth.AuthUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

    @GetMapping("/auth")
    public CMRespDto<?> 인증코드확인(String phoneNumber){
        return new CMRespDto<>(1,authService.인증코드확인(phoneNumber));
    }

    @PostMapping("/auth")
    public CMRespDto<?> 인증코드전송(@RequestBody AuthSaveReqDto authSaveReqDto){
        return new CMRespDto<>(1,authService.문자전송후save(authSaveReqDto));
    }

    @DeleteMapping("/auth")
    public CMRespDto<?> 인증코드삭제(int id){
        authService.인증코드삭제(id);
        return new CMRespDto<>(1, null);
    }

    @PutMapping("/auth")
    public CMRespDto<?> 인증코드수정(int id, AuthUpdateReqDto authUpdateReqDto){
        return new CMRespDto<>(1,authService.인증코드수정(id,authUpdateReqDto));
    }
}
