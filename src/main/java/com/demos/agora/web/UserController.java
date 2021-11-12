package com.demos.agora.web;

import com.demos.agora.service.UserService;
import com.demos.agora.web.dto.CMRespDto;
import com.demos.agora.web.dto.user.UserRegistryReqDto;
import com.demos.agora.web.dto.user.UserSaveReqDto;
import com.demos.agora.web.dto.user.UserUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {
    // @RequestMapping, GetMapping, PostMapping, DeleteMapping, PutMapping
    private final UserService userService;
    
    // GetMapping : HTTP Get 요청 처리, Header에 data를 담아 보냄(용량 한계 존재)
    @GetMapping("/user/phoneNumber")
    public CMRespDto<?> 유저확인(String phoneNumber) {
        return new CMRespDto<>(1, userService.유저확인(phoneNumber));
    }

    @GetMapping("/user/nickName")
    public CMRespDto<?> 닉네임중복체크(String nickName) {
        return new CMRespDto<>(1, userService.닉네임중복체크(nickName));
    }

    @GetMapping("/user/{id}")
    public CMRespDto<?> 유저ID로확인(@PathVariable int id) {
        return new CMRespDto<>(1, userService.유저ID로확인(id));
    }

    // @PostMapping : HttpBody에 정보를 담아 보내므로 Get방식보다 안전하게 새로운 data를 등록할 때 사용
    @PostMapping("/user")
    public CMRespDto<?> 회원가입(@RequestBody UserSaveReqDto userSaveReqDto) {
        return new CMRespDto<>(1, userService.회원가입(userSaveReqDto));
    }
    
    // @PutMapping : update 작업 수행 시 사용
    @PutMapping("/user/registry")
    public CMRespDto<?> 유저정보(@RequestBody UserRegistryReqDto userRegistryReqDto){
        return new CMRespDto<>(1, userService.유저정보(userRegistryReqDto)); // error
    }

    @PutMapping("/user/{id}")
    public CMRespDto<?> 닉네임AND포토이미지변경(@PathVariable int id,@RequestBody UserUpdateReqDto userUpdateReqdto) {
        return new CMRespDto<>(1, userService.닉네임AND프로필변경(id, userUpdateReqdto));
    }

}
