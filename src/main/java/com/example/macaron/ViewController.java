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
    // model.addAttribute("Sale", viewService.previewSale().getSale());
    // model.addAttribute("SuddenSale", viewService.previewSale().getSsale());
    // model.addAttribute("Store", viewService.previewSale().getStore());
    // return "dotachan/home";
    // }

    // キーワードサーチ
    // @GetMapping("/keywordSerch")
    // public String storeSerch(@RequestParam String keyword, Model model) {
    // model.addAttribute("Sale",
    // viewService.saleserchByKeyword(keyword).getSale());
    // model.addAttribute("SuddenSale", viewService.previewSale().getSsale());
    // model.addAttribute("Store", viewService.previewSale().getStore());
    // return "dotachan/home";
    // }
    @GetMapping("/keywordSerch")
    public String storeSerch(@RequestParam String keyword, Model model) {
        model.addAttribute("Sale", viewService.saleserchByKeyword(keyword).getSale());
        // model.addAttribute("SuddenSale",
        // viewService.serchByGenre(genreSerch).getSsale());
        // model.addAttribute("Store", viewService.serchByGenre(genreSerch).getStore());

        // 広告用店舗
        List<Storeview> storead = viewService.previewAd();
        model.addAttribute("Storead", storead);

        // IDの大きい順SuddenSale
        List<SuddenSaleview> suddensaleList = viewService.suddensale();
        model.addAttribute("SuddenSale", suddensaleList);

        // IDの大きい順店舗
        List<Storeview> sstore = viewService.previewSStorehome();
        model.addAttribute("SStores", sstore);

        return "dotachan/home";
    }

    // ジャンルサーチ
    // @GetMapping("/genreSerch")
    // public String genreSerch(@RequestParam String genreSerch, Model model) {
    // model.addAttribute("Sale", viewService.serchByGenre(genreSerch).getSale());
    // model.addAttribute("SuddenSale", viewService.previewSale().getSsale());
    // model.addAttribute("Store", viewService.previewSale().getStore());
    // return "dotachan/home";
    // }

    @GetMapping("/genreSerch")
    public String genreSerch(@RequestParam String genreSerch, Model model) {
        model.addAttribute("Sale", viewService.serchByGenre(genreSerch).getSale());
        // model.addAttribute("SuddenSale",
        // viewService.serchByGenre(genreSerch).getSsale());
        // model.addAttribute("Store", viewService.serchByGenre(genreSerch).getStore());

        // 広告用店舗
        List<Storeview> storead = viewService.previewAd();
        model.addAttribute("Storead", storead);

        // IDの大きい順SuddenSale
        List<SuddenSaleview> suddensaleList = viewService.suddensale();
        model.addAttribute("SuddenSale", suddensaleList);

        // IDの大きい順店舗
        List<Storeview> sstore = viewService.previewSStorehome();
        model.addAttribute("SStores", sstore);

        return "dotachan/home";
    }

    // @GetMapping("/genreSerch")
    // public String genreSerch(@RequestParam String keyword, Model model) {
    // List<Storeview> storeOpt = viewService.previewAd();
    // model.addAttribute("Store", storeOpt);

    // List<Saleview> saleList = viewService.saleserchByGenre(keyword);
    // model.addAttribute("Sale", saleList);

    // List<SuddenSaleview> suddensaleList = viewService.suddensale();
    // model.addAttribute("SuddenSale", suddensaleList);
    // return "dotachan/home";
    // }

    // @GetMapping("/genreSerch")
    // public String genreSerch(@RequestParam String genreSerch, Model model) {

    // // List<Saleview> genreSale = viewService.saleserchByGenre(genreSerch);
    // // model.addAttribute("genreSerch", genreSale);

    // Saledto genreDto = viewService.saleserchByGenre(genreSerch);
    // model.addAttribute("genreStore", genreDto.getStore());
    // model.addAttribute("genreSale", genreDto.getSale());

    // // 店舗の広告（ランダム）
    // List<Storeview> storead = viewService.previewAd();
    // model.addAttribute("Storead", storead);

    // // 通常のセール

    // // IDの大きい順
    // List<SuddenSaleview> suddensaleList = viewService.suddensale();
    // model.addAttribute("SuddenSale", suddensaleList);

    // // IDの小さい順
    // List<Storeview> store = viewService.previewStorehome();
    // model.addAttribute("Stores", store);

    // // IDの大きい順
    // List<Storeview> sstore = viewService.previewSStorehome();
    // model.addAttribute("SStores", sstore);
    // return "dotachan/genre";
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

    // 迎田祐圭
    @GetMapping("/home")
    public String saleDetail(Model model) {
        // 店舗の広告（ランダム）
        List<Storeview> storead = viewService.previewAd();
        model.addAttribute("Storead", storead);

        // 通常のセール
        List<Saleview> saleList = viewService.sale();
        model.addAttribute("Sale", saleList);

        // IDの大きい順
        List<SuddenSaleview> suddensaleList = viewService.suddensale();
        model.addAttribute("SuddenSale", suddensaleList);

        // IDの小さい順
        List<Storeview> store = viewService.previewStorehome();
        model.addAttribute("Stores", store);

        // IDの大きい順
        List<Storeview> sstore = viewService.previewSStorehome();
        model.addAttribute("SStores", sstore);

        return "dotachan/home";
    }

}
