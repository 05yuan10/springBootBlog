package me.limyuan.springbootdeveloper.controller;

import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import me.limyuan.springbootdeveloper.dto.AddUserRequest;
import me.limyuan.springbootdeveloper.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest addUserRequest) {
        userService.save(addUserRequest); // 회원 가입 메서드 호출
        return "redirect:/login"; // 회원 가입이 완료된 이후에 로그인 페이지로 이동
    }
}