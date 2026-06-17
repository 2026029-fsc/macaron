package com.example.macaron;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
    private final UserService userService;
    private final StoreService storeService;

    public LoginController(UserService userService, StoreService storeService){
        this.userService = userService;
        this.storeService = storeService;

    }
    
  //一般ユーザログイン
  @GetMapping("/userLogin")
  public String userLoginForm() {
    return "userLogin";
  }

  @PostMapping("/userLogin")
  public String login(@ModelAttribute LoginForm form, HttpSession session, RedirectAttributes redirectAttributes) {
    if (userService.authenticate(form.getEmail(), form.getPassword())) {
      session.setAttribute("userEmail", form.getEmail());
      return "redirect:/mypage";
    }

    redirectAttributes.addFlashAttribute("errorMessage", "ユーザー名かパスワードが違います");
    return "redirect:/userLogin";
  }

  //店舗ログイン
  @GetMapping("/storeLogin")
  public String storeLoginForm() {
    return "storeLogin";
  }

  @PostMapping("/storeLogin")
  public String login(@ModelAttribute LoginForm form, HttpSession session,RedirectAttributes redirectAttributes) {
    if (StoreService.authenticate(form.getEmail(), form.getPassword())) {
      session.setAttribute("storeEmail", form.getEmail());
      return "redirect:/mystore";
    }
    redirectAttributes.addFlashAttribute("errorMessage", "ユーザー名かパスワードが違います");
    return "redirect:/storeLogin";
  }

  //ログアウト処理
  @PostMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }
}