package org.kernel360.orury.user.controller;

import lombok.RequiredArgsConstructor;
import org.kernel360.orury.user.dto.UserDto;
import org.kernel360.orury.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String getSignUp(UserDto userDto) {
        return "user/createUserForm";
    }

    @PostMapping("/signup")
    public String postSignUp(UserDto userDto) {
        userService.saveUser(userDto);
        return "redirect:/";
    }
}
