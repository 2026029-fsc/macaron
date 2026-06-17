package com.example.macaron;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

// 今岡変更
    // localhost:8080/registerをブラウザで入力。
    @PostMapping("/correct")
    public String userRegister(@ModelAttribute UserForm form, Model model) {  // 入力した値をModelにわたす。
        
        // パスワードの一致チェック 
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            model.addAttribute("passError", "パスワードと確認用パスワードが一致しません。");
            return "dotachan/register"; 
        }
        // 一致していた場合のみ、サービスを呼び出してDB保存する
        userSubmitService.userRegister(form);
        return "redirect:/dotachan/correct"; 
    }

//今岡変更ここまで


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
    @GetMapping("/mypage")
    public String mypage(@PathVariable Long id, Model model) {//ブラウザでもらった値をjavaに変換、モデルに渡す
        Optional<User> userOpt = userSubmitService.findById(id);//サービスにお願いする(リポジトリを通り、データベースから値をもらう)
        model.addAttribute("user", userOpt.get());//"user"という箱に詰める
        return "/mypage";//表示させるhtml
    }
    
}


