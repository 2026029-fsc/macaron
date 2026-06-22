package com.example.macaron;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserSubmitController {

  private final UserSubmitService userSubmitService;

  public UserSubmitController(UserSubmitService userSubmitService){
    this.userSubmitService = userSubmitService;
  }

  // 西山 店舗に対する口コミの送信
  @PostMapping("/store_detail/{id}")
  public String detailpost(@PathVariable Long id, @ModelAttribute StoreReviewForm form) {
    userSubmitService.post(id,form);
    return "redirect:/store_detail/{id}";   
  }
}
