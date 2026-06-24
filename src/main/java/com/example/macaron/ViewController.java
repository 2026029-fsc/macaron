package com.example.macaron;

import java.util.List;
import java.util.Optional;
// import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewController {
    private ViewService viewService;
    private UserSubmitService userSubmitService;

    public ViewController(ViewService viewService, UserSubmitService userSubmitService) {
        this.viewService = viewService;
        this.userSubmitService = userSubmitService;
    }

    // キーワードサーチ
    @GetMapping("/keywordSerch")
    public String storeSerch(@RequestParam String keyword, Model model) {
        model.addAttribute("Sale", viewService.saleserchByKeyword(keyword).getSale());

        // 広告用店舗
        List<Storeview> storead = viewService.previewAd();
        model.addAttribute("Storead", storead);

        // IDの大きい順SuddenSale
        List<SuddenSaleview> suddensaleList = viewService.suddensale();
        model.addAttribute("SuddenSale", suddensaleList);

        return "dotachan/home";
    }

    // ジャンルサーチ
    @GetMapping("/genreSerch")
    public String genreSerch(@RequestParam String genreSerch, Model model) {
        model.addAttribute("Sale", viewService.serchByGenre(genreSerch).getSale());

        // 広告用店舗
        List<Storeview> storead = viewService.previewAd();
        model.addAttribute("Storead", storead);

        // IDの大きい順SuddenSale
        List<SuddenSaleview> suddensaleList = viewService.suddensale();
        model.addAttribute("SuddenSale", suddensaleList);

        return "dotachan/home";
    }

    // 西山 店舗の詳細表示
    @GetMapping("/store_detail/{id}")
    public String detail(@PathVariable Integer id, Model model, HttpSession session) {
        Optional<Storeview> storeOpt = viewService.StoreDetailId(id);
        if (storeOpt.isEmpty()) {
            return "redirect:/home";
        }

        // セッションのメールアドレスからユーザー情報を取得する
        String email = (String) session.getAttribute("userEmail");
        User user = userSubmitService.findByMail(email).orElse(null);
        if (user != null) {
            model.addAttribute("user", user);// HTML側にuserという名前でデータを渡す
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

    // 迎田祐圭 ホーム一覧表示
    @GetMapping("/home")
    public String saleDetail(Model model) {
        // 店舗の広告（ランダム）
        List<Storeview> storead = viewService.previewAd();
        model.addAttribute("Storead", storead);

        // 通常のセール、店舗表示
        List<Saleview> saleList = viewService.sale();
        model.addAttribute("Sale", saleList);

        // IDの大きい順に突発セール、店舗表示
        List<SuddenSaleview> suddensaleList = viewService.suddensale();
        model.addAttribute("SuddenSale", suddensaleList);

        return "dotachan/home";
    }

}
