package com.example.macaron;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    private ViewService viewService;

    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @GetMapping("/home")
    public String home() {
    return "dotachan/home";
    }

    @GetMapping("/home")
    public String saleDetail(@PathVariable Long id, Model model) {
    Optional<Sale> blogOpt = viewService.findById(id);
    if (blogOpt.isEmpty()) {
    return "redirect:/blog";
    }
    model.addAttribute("store", StoreOpt.get());
    return "store/detail";// 戻るHTML
    }


    //全体サーチ
    @GetMapping("/home")
    public String saleDetail(Model model) {
        model.addAttribute("Sale", viewService.previewSale().getSale());
        model.addAttribute("SuddenSale", viewService.previewSale().getSsale());
        return "dotachan/home";
    }

    @GetMapping("/keywordSerch")
    public String storeSerch(@RequestParam String keyword, Model model) {
        model.addAttribute("Sale", viewService.saleserchByKeyword(keyword).getSale());
        model.addAttribute("SuddenSale", viewService.previewSale().getSsale());
        return "dotachan/home";
    }

    //ジャンルサーチ
    @GetMapping("/genreSerch")
    public String genreSerch(@RequestParam String genreSerch, Model model) {
        model.addAttribute("Sale", viewService.serchByGenre(genreSerch).getSale());
        model.addAttribute("SuddenSale", viewService.previewSale().getSsale());
        return "dotachan/home";
    }

    
    //西山 店舗の詳細表示
    @GetMapping("/store_detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        Optional<Store> storeOpt = viewService.StoreDetailId(id);
        if(storeOpt.isEmpty()){
            return "redirect:/home";
        }
        model.addAttribute("Store",storeOpt.get());

        List<Sale> saleList = viewService.SaleDetailId(id);
        model.addAttribute("Sales",saleList);

        List<SuddenSale> ssaleList = viewService.SSaleDetailId(id);
        model.addAttribute("SuddenSales",ssaleList);

        List<Review> review = viewService.reviews(id);
        model.addAttribute("Review",review);

        return "dotachan/StoreDetail";
    }

    @PostMapping("/store_detail/{id}")
    public String detailpost()

}
