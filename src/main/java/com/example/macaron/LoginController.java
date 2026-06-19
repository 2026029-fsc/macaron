package com.example.macaron;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.model.Model;


// @Controller
// public class LoginController {
//     private final UserSubmitService userSubmitService;
//     private final StoreService storeService;

//     public LoginController(UserSubmitService userSubmitService, StoreService storeService){
//         this.userSubmitService = userSubmitService;
//         this.storeService = storeService;

//     }
@Controller
public class LoginController {
    private final UserSubmitService userSubmitService;


    public LoginController(UserSubmitService userSubmitService){
        this.userSubmitService = userSubmitService;
    }
    
  //一般ユーザログイン
  @GetMapping("/userLogin")
  public String userLoginForm() {
    return "userLogin";
  }


  @PostMapping("/userLogin")
  public String userLogin(@ModelAttribute LoginForm form, HttpSession session, RedirectAttributes redirectAttributes) {
    // ユーザー情報の取得
    if (userSubmitService.authenticate(form.getMail(), form.getPassword())) {
      User user = userSubmitService.findByMail(form.getMail()).orElse(null);   //メアドで取得
      session.setAttribute("userId", user.getId());
      session.setAttribute("userEmail", form.getMail());
      return "redirect:/mypage"; //+ user.getId();// + user.getId();    // 各ユーザーのマイページへリダイレクト
    }
    redirectAttributes.addFlashAttribute("errorMessage", "ユーザー名かパスワードが違います");
    return "redirect:/userLogin";
}


  @GetMapping("/mypage")
  public String showMyPage(HttpSession session, Model model) {
      // セッションからユーザーIDを取得
      Long userId = (Long) session.getAttribute("userId");
      
      if (userId == null) {
          return "redirect:/userLogin";
      }
      
      return "mypage"; 
  }




  //店舗ログイン
  @GetMapping("/storeLogin")
  public String storeLoginForm() {
    return "storeLogin";
  }

  // @PostMapping("/storeLogin")
  // public String storeLogin(@ModelAttribute LoginForm form, HttpSession session,RedirectAttributes redirectAttributes) {
  //   if (storeService.authenticate(form.getEmail(), form.getPassword())) {
  //     Store store = storeService.findByEmail(form.getEmail());
  //     session.setAttribute("id", store.getId());
  //     session.setAttribute("storeEmail", form.getEmail());
  //     return "redirect:/mystore"+ store.getId();
  //   }
  //   redirectAttributes.addFlashAttribute("errorMessage", "ユーザー名かパスワードが違います");
  //   return "redirect:/storeLogin";
  // }

  //ログアウト処理
  @PostMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }


  @GetMapping("/privacy-policy")
    public String privacypolicy() {
        return "/privacy-policy";
    }

  @GetMapping("/agreement")
    public String agreement() {
        return "/agreement";
  }
}
