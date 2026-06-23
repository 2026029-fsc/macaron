package com.example.macaron;

//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserSubmitController {
  private final UserSubmitService userSubmitService;
  UserForm user = new UserForm();

  public UserSubmitController(UserSubmitService userSubmitService) {
    this.userSubmitService = userSubmitService;
  }

  // localhost:8080/resisterをブラウザ(URL)で入力したときに表示させる
  @GetMapping("/register")
  public String register(Model model) {
    model.addAttribute("userform", new UserForm());
    return "dotachan/register";
  }

  @PostMapping("/register")
  // 新規会員登録するときのメソッド
  // 入力内容でエラーになるとregisterに戻す
  public String register(@Validated @ModelAttribute("userform") UserForm form, BindingResult result, Model model) {
    // model.addAttribute("UserForm", user);
    if (result.hasErrors()) {
      return "dotachan/register";
    }
    // エラーでなければcorrectに行き、入力した値をサービスに渡す↓
    userSubmitService.register(form.getName(), form.getMail(), form.getPassword());
    return "redirect:/correct";
  }

  // localhost:8080/correctをブラウザで入力
  @GetMapping("/correct")
  public String correct() {
    return "dotachan/correct";// 表示させるhtml
  }

  // localhost:8080/subscribeをブラウザで入力
  @GetMapping("/subscribe")
  public String subscribe() {
    return "dotachan/subscribe";// 表示させるhtml
  }

  @PostMapping("/store_detail/{id}")
  public String detailpost(@PathVariable Integer id, @ModelAttribute StoreReviewForm form, HttpSession session) {
    Integer user_id = (int)session.getAttribute("userId");
    userSubmitService.post(id,form, user_id);
    return "redirect:/store_detail/{id}";   
  }

  // どのコントローラーに書くかわからんけど、、、、
  // クーポン一覧を表示する
  // @GetMapping("/mypage")
  // public String coupon(Model model) {
    
    
  //   return ""; // マイページを表示
  // }

}
