package com.demos.agora.web;

import com.demos.agora.service.UserService;
import com.demos.agora.web.dto.CMResDto;
import com.demos.agora.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/registUser")
    public CMResDto<?> createUser(@Valid UserDto form, BindingResult result){
        if(result.hasErrors()){
            return new CMResDto<>(1, userService.registUser(form));//실패할경우 어떻게 해야할지ㅣ 모르겠음...
        }
       userService.registUser(form);

       return new CMResDto<>(1, userService.registUser(form)); //이게 맞나 모르겠음...
    }
}
