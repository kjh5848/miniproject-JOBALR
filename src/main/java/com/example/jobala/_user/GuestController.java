package com.example.jobala._user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class GuestController {




    @PostMapping("/guest/join")
    public String join(){
        return "redirect:/user/loginForm";
    }
    @GetMapping("/guest/joinForm")
    public String loginForm(){
        return "/guest/joinForm";
    }
}
