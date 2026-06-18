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

    // 全体サーチ表示（ホーム）
    // @GetMapping("/home")
    // public String saleDetail(Model model) {
    //     model.addAttribute("Sale", viewService.previewSale().getSale());
    //     model.addAttribute("SuddenSale", viewService.previewSale().getSsale());
    //     model.addAttribute("Store", viewService.previewSale().getStore());
    //     return "dotachan/home";
    // }

    // キーワードサーチ
    @GetMapping("/keywordSerch")
    // public String storeSerch(@RequestParam String keyword, Model model) {
    //     model.addAttribute("Sale", viewService.saleserchByKeyword(keyword).getSale());
    //     model.addAttribute("SuddenSale", viewService.previewSale().getSsale());
    //     model.addAttribute("Store", viewService.previewSale().getStore());
    //     return "dotachan/home";
    // }

    public String storeSerch(@RequestParam String keyword, Model model) {
        List<Storeview> storeOpt = viewService.previewAd();
        model.addAttribute("Store", storeOpt);

        List<Saleview> saleList = viewService.saleserchByKeyword(keyword);
        model.addAttribute("Sale", saleList);

        List<SuddenSaleview> suddensaleList = viewService.suddensale();
        model.addAttribute("SuddenSale", suddensaleList);
        return "dotachan/home";
    }



    // ジャンルサーチ
    @GetMapping("/genreSerch")
    // public String genreSerch(@RequestParam String genreSerch, Model model) {
    //     model.addAttribute("Sale", viewService.serchByGenre(genreSerch).getSale());
    //     model.addAttribute("SuddenSale", viewService.previewSale().getSsale());
    //     model.addAttribute("Store", viewService.previewSale().getStore());
    //     return "dotachan/home";
    // }

    public String genreSerch(@RequestParam String keyword, Model model) {
        List<Storeview> storeOpt = viewService.previewAd();
        model.addAttribute("Store", storeOpt);

        List<Saleview> saleList = viewService.saleserchByGenre(keyword);
        model.addAttribute("Sale", saleList);

        List<SuddenSaleview> suddensaleList = viewService.suddensale();
        model.addAttribute("SuddenSale", suddensaleList);
        return "dotachan/home";
    }

    // // 店舗詳細表示
    // @GetMapping("/home/{id}")
    // public String detail(@PathVariable Long id, Model model) {
    //     Optional<Storeview> storeOpt = viewService.storeDetailById(id);
    //     Optional<Saleview> saleOpt = viewService.saleDetailById(id);
    //     Optional<SuddenSaleview> ssaleOpt = viewService.suddensalDetailById(id);
    //     if (storeOpt.isEmpty() || saleOpt.isEmpty() || ssaleOpt.isEmpty()) {
    //         return "redirect:/home";
    //     }
    //     model.addAttribute("Store", storeOpt.get());
    //     model.addAttribute("Sale", saleOpt.get());
    //     model.addAttribute("SuddenSale", ssaleOpt.get());
    //     return "dotachan/storeDetail";// 戻るHTML
    // }

    // 西山 店舗の詳細表示
    @GetMapping("/store_detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Storeview> storeOpt = viewService.StoreDetailId(id);
        if (storeOpt.isEmpty()) {
            return "redirect:/home";
        }
        model.addAttribute("Store", storeOpt.get());

        List<Saleview> saleList = viewService.SaleDetailId(id);
        model.addAttribute("Sales", saleList);

        List<SuddenSaleview> ssaleList = viewService.SSaleDetailId(id);
        model.addAttribute("SuddenSales", ssaleList);

        List<Review> review = viewService.reviews(id);
        model.addAttribute("Review", review);

        return "dotachan/StoreDetail";
    }

    //迎田祐圭
    @GetMapping("/home")
    public String saleDetail(Model model) {
        List<Storeview> storeOpt = viewService.previewAd();
        model.addAttribute("Store", storeOpt);

        List<Saleview> saleList = viewService.sale();
        model.addAttribute("Sale", saleList);

        List<SuddenSaleview> suddensaleList = viewService.suddensale();
        model.addAttribute("SuddenSale", suddensaleList);
        
        return "dotachan/home";
    }



}
