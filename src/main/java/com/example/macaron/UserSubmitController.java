package com.example.macaron;

import java.util.Optional;

//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
  public String register(@Validated @ModelAttribute("userform") UserForm form, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
    // model.addAttribute("UserForm", user);
    if (result.hasErrors()) {
      return "dotachan/register";
      // メールアドレスがすでに登録されていたらエラー表示
    } else if (userSubmitService.existsByMail(form.getMail())) {
      model.addAttribute("error", "このメールアドレスは既に登録されています。");
      return "dotachan/register";
    }
    // エラーでなければcorrectに行き、入力した値をサービスに渡す↓
    userSubmitService.register(form.getName(), form.getMail(), form.getPassword());
    Optional<User> registeredUser = userSubmitService.findByMail(form.getMail()); 
    redirectAttributes.addFlashAttribute("user", registeredUser);
    return "redirect:/correct";
  }

  // localhost:8080/correctをブラウザで入力
  // @postmapping /register のaddFlashAttribute によりModelには既にuserを格納済み
  @GetMapping("/correct")
  public String correct(Model model) {
    if (!model.containsAttribute("user")) {
        return "redirect:/register"; 
    }
    return "dotachan/correct";// 表示させるhtml
  }

  // localhost:8080/subscribeをブラウザで入力
  @GetMapping("/subscribe")
  public String subscribe() {
    return "dotachan/subscribe";// 表示させるhtml
  }

  @PostMapping("/store_detail/{id}")
  public String detailpost(@PathVariable Integer id, @ModelAttribute StoreReviewForm form, HttpSession session) {
    Integer user_id = (int) session.getAttribute("userId");
    userSubmitService.post(id, form, user_id);
    return "redirect:/store_detail/{id}";
  }

}
