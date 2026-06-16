package com.example.macaron;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(loginService loginService){
        this.loginService = loginService;
    }
    
  @GetMapping("/login")
  public String loginForm() {
    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute LoginForm form, HttpSession session,RedirectAttributes redirectAttributes) {
    if (userService.authenticate(form.getMail(), form.getPassword())) {
      session.setAttribute("username", form.getUsername());
      redirectAttributes.addFlashAttribute("message", "ログインしました");
      return "redirect:/mypage";
    }
    if (StoreService.authenticate(form.getname(), form.getPassword())) {
      session.setAttribute("name", form.name());
      redirectAttributes.addFlashAttribute("errorMessage", "ログインしました");
      return "redirect:/mystore";
    }
    redirectAttributes.addFlashAttribute("errorMessage", "ユーザー名かパスワードが違います");
    return "redirect:/login";
  }

  @PostMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/books";
  }
}