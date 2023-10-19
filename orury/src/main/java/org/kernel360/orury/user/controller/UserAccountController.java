package org.kernel360.orury.user.controller;

import org.kernel360.orury.board.comment.domain.Comment;
import org.kernel360.orury.board.post.domain.Post;
import org.kernel360.orury.user.domain.UserAccount;
import org.kernel360.orury.user.dto.UserAccountDto;
import org.kernel360.orury.user.repository.UserAccountRepository;
import org.kernel360.orury.user.service.UserAccountService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserAccountController {

    private UserAccountService userAccountService;
    private UserAccountRepository userAccountRepository;
    private UserAccountDto userAccountDto;
    private UserAccount userAccount;
    @GetMapping("/signup")
    public String createSignUp(@RequestBody UserAccountDto userAccountDto) {
        return "userCreateForm";
    }

    @PostMapping("/signup")
    public String createSignUp(String userId, UserAccountDto userAccountDto) {
        userAccountService.saveUser(userAccountDto);
        return "/user/{userId}";
    }
    @GetMapping("/user/{userId}")
    public UserAccountDto viewUserDetail(UserAccountDto userAccountDto) {
        return userAccountDto;
    }

    @PostMapping("/user/{userId}")
    public String updateUserDetail(
            Long userId
            ,@RequestBody String nickname
            ,@RequestBody String password
            ,@RequestBody String email
            ,Model model) {
        userAccountRepository.save(UserAccount);
        return "UserDetail";
    }
}