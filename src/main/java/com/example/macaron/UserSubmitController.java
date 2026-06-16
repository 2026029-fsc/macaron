package com.example.macaron;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserSubmitController {
    private final UserSubmitService userSubmitService;

    public UserSubmitController(UserSubmitService userSubmitService){
        this.userSubmitService = userSubmitService;
    }

    @GetMapping("/register")
    public String resister() {
        return "register";
    }
    
    @PostMapping("/register")
        public String userRegister(@ModelAttribute UserForm form) {
        userSubmitService.userRegister(form);
        return "redirect:/correct";
        }
    }

