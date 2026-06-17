package com.example.macaron;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserSubmitController {
    private final UserSubmitService userSubmitService;

    public UserSubmitController(UserSubmitService userSubmitService) {
        this.userSubmitService = userSubmitService;
    }

    // localhost:8080/resisterをブラウザ(URL)で入力したときに表示させる
    @GetMapping("/register")
    public String register() {
        return "dotachan/register";
    }

    // localhost:8080/resisterをブラウザで入力。
    @PostMapping("/correct")
    public String userRegister(@ModelAttribute UserForm form) { // 入力した値をModelにわたす。
        userSubmitService.userRegister(form); // サービス、に渡す(その後リポジトリを通り、データベースに保存する。)

        return "redirect:/dotachan/correct"; // 戻るURLのhtml
    }

    // localhost:8080/correctをブラウザで入力
    @GetMapping("/correct")
    public String correct() {
        return "/dotachan/correct";// 表示させるhtml
    }

    //localhost:8080/subscribeをブラウザで入力
    @GetMapping("/subscribe")
    public String subscribe() {
        return "/dotachan/subscribe";//表示させるhtml
    }

    
    

}
