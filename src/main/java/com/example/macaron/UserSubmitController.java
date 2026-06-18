package com.example.macaron;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

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
        userSubmitService.register(form.getName(),form.getMail(),form.getPassword()); // サービス、に渡す(その後リポジトリを通り、データベースに保存する。)
        return "redirect:/dotachan/correct"; // 戻るURLのhtml
    }

    // localhost:8080/correctをブラウザで入力
    @GetMapping("/dotachan/correct")
    public String correct() {
        return "/dotachan/correct";// 表示させるhtml
    }

    // localhost:8080/subscribeをブラウザで入力
    @GetMapping("/subscribe")
    public String subscribe() {
        return "/dotachan/subscribe";// 表示させるhtml
    }

    // マイページにデータベースから持ってきた値を表示させたい
    @GetMapping("/mypage/{id}")
    public String mypage(@PathVariable Long id, Model model) {//ブラウザでもらった値をjavaに変換、モデルに渡す
        Optional<User> userOpt = userSubmitService.findById(id);//サービスにお願いする(リポジトリを通り、データベースから値をもらう)
        model.addAttribute("user", userOpt.get());//"user"という箱に詰める
        return "/mypage/{id}";//表示させるhtml
    }

       @PostMapping("/register")
    public String register(
            @RequestParam String name,
            @RequestParam String mail,
            @RequestParam String password,
            Model model) {

        if (name.isBlank() || mail.isBlank() || password.isBlank()) {
            model.addAttribute("errorMessage", "すべての項目を入力してください。");
            return "/register";
        }
        userSubmitService.register(name, mail, password);

        return "redirect:/correct";
    }
}
