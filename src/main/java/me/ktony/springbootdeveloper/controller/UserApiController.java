package me.ktony.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.ktony.springbootdeveloper.dto.AddUserRequest;
import me.ktony.springbootdeveloper.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        userService.save(request);
        return "redirect:/login";
    }

}
