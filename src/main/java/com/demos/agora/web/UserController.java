package com.demos.agora.web;

import com.demos.agora.service.UserService;
import com.demos.agora.web.dto.CMRespDto;
import com.demos.agora.web.dto.user.UserDto;
import com.demos.agora.web.dto.user.UserSaveReqDto;
import com.demos.agora.web.dto.user.UserUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    @PostMapping("/registry")
//    public CMRespDto<?> createUser(@Valid UserDto form, BindingResult result){
//        if(result.hasErrors()){
//            return new CMRespDto<>(1, userService.registUser(form));//실패할경우 어떻게 해야할지ㅣ 모르겠음...
//        }
//       userService.registUser(form);
//
//       return new CMRespDto<>(1, userService.registUser(form)); //이게 맞나 모르겠음...
//    }

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

    @PostMapping("/user")
    public CMRespDto<?> 회원가입(@RequestBody UserSaveReqDto userSaveReqDto) {
        return new CMRespDto<>(1, userService.회원가입(userSaveReqDto));
    }

    @PutMapping("/user/{id}")
    public CMRespDto<?> 닉네임AND포토이미지변경(@PathVariable int id,@RequestBody UserUpdateReqDto userUpdateReqdto) {
        return new CMRespDto<>(1, userService.닉네임AND프로필변경(id, userUpdateReqdto));
    }



}
