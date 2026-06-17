package com.example.macaron;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    private ViewService viewService;

    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    // @GetMapping("/home")
    // public String home() {
    // return "dotachan/home";
    // }

    // @GetMapping("/home")
    // public String saleDetail(@PathVariable Long id, Model model) {
    // Optional<Sale> blogOpt = viewService.findById(id);
    // if (blogOpt.isEmpty()) {
    // return "redirect:/blog";
    // }
    // model.addAttribute("store", StoreOpt.get());
    // return "store/detail";// 戻るHTML
    // }

    @GetMapping("/home")
    public String saleDetail(Model model) {
        model.addAttribute("Sale", viewService.previewSale().getSale());
        model.addAttribute("SuddenSale", viewService.previewSale().getSsale());
        return "dotachan/home";
    }

    @GetMapping("/keywordSerch")
    public String storeSerch(@RequestParam String keywordSerch, Model model) {
        model.addAttribute("Sale", viewService.storeSaleSerch(keywordSerch));
        return "dotachan/home";
    }

    @GetMapping("/genreSerch")
    public String genreSerch(@RequestParam String keywordSerch, Model model) {
        model.addAttribute("Sale", viewService.storeSaleSerch(keywordSerch));
        return "dotachan/home";
    }
}
