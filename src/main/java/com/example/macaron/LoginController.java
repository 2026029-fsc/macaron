package com.example.macaron;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@Controller
public class LoginController {
  private final UserSubmitService userSubmitService;
  // private final StoreSubmitService storeSubmitService;

  public LoginController(UserSubmitService userSubmitService) {// , StoreSubmitService storeSubmitService){
    this.userSubmitService = userSubmitService;
    // this.storeSubmitService = storeSubmitService;
  }

  // 一般ユーザログイン画面表示
  @GetMapping("/userLogin")
  public String userLoginForm() {
    return "dotachan/userLogin";
  }

  // ユーザーログイン処理
  @PostMapping("/userLogin")
  public String userLogin(@ModelAttribute LoginForm form, HttpSession session, RedirectAttributes redirectAttributes) {
    // ユーザー情報の取得
    if (userSubmitService != null && userSubmitService.authenticate(form.getMail(), form.getPassword())) {
      User user = userSubmitService.findByMail(form.getMail()).orElse(null); // メアドで取得
      if (user != null) {
        session.setAttribute("userId", user.getId());
        session.setAttribute("userEmail", form.getMail());
        return "redirect:/mypage"; // 各ユーザーのマイページへリダイレクト
      }
    }
    redirectAttributes.addFlashAttribute("errorMessage", "メールアドレスかパスワードが違います");
    return "redirect:/userLogin";
  }

  // ユーザーマイページの表示
  @GetMapping("/mypage")
  public String showMyPage(HttpSession session, Model model) {

    List<Store> store = userSubmitService.findByIdCoupon();// couponという変数 サービスにfindByIdCouponをおねがいする
    model.addAttribute("store", store);// 変数couponを"coupon"という箱にいれる
    // セッションからユーザーIDを取得
    Long userId = (Long) session.getAttribute("userId");

    if (userId == null) {
      return "redirect:/userLogin";
    }
    // セッションのメールアドレスからユーザー情報を取得する
    String email = (String) session.getAttribute("userEmail");
    User user = userSubmitService.findByMail(email).orElse(null);

    model.addAttribute("user", user);// HTML側にuserという名前でデータを渡す
    return "dotachan/mypage";
  }

  // //店舗ログイン
  // @GetMapping("/storeLogin")
  // public String storeLoginForm() {
  // return "storeLogin";
  // }
  // // 店舗ログイン処理
  // @PostMapping("/storeLogin")
  // public String storeLogin(@ModelAttribute LoginForm form, HttpSession session,
  // RedirectAttributes redirectAttributes) {
  // // 店舗情報の取得
  // if (storeSubmitService != null &&
  // storeSubmitService.authenticate(form.getMail(), form.getPassword())) {
  // Store store = storeSubmitService.findByMail(form.getMail()).orElse(null);
  // //メアドで取得
  // if(store != null){
  // session.setAttribute("storeId", store.getId());
  // session.setAttribute("storeEmail", form.getMail());
  // return "redirect:/storemypage"; // 各店舗のマイページへリダイレクト
  // }
  // }
  // redirectAttributes.addFlashAttribute("errorMessage", "メールアドレスかパスワードが違います");
  // return "redirect:/storeLogin";
  // }

  // // 店舗マイページの表示
  // @GetMapping("/storemypage")
  // public String showStoreMyPage(HttpSession session, Model model) {
  // // セッションからユーザーIDを取得
  // Long storeId = (Long) session.getAttribute("storeId");

  // if (storeId == null) {
  // return "redirect:/userLogin";
  // }
  // // セッションのメールアドレスからユーザー情報を取得する
  // String email = (String) session.getAttribute("storeEmail");
  // User user = storeSubmitService.findByMail(email).orElse(null);

  // model.addAttribute("store", store);//HTML側に「store」という名前でデータを渡す
  // return "mypage";
  // }

  // ログアウト処理
  @PostMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

  @GetMapping("/privacy-policy")
  public String privacypolicy() {
    return "dotachan/privacy-policy";
  }

  @GetMapping("/agreement")
  public String agreement() {
    return "dotachan/agreement";
  }
}
