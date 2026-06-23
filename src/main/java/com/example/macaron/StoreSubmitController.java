package com.example.macaron;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

@Controller
public class StoreSubmitController {
    private final StoreSubmitService storeSubmitService;

    public StoreSubmitController(StoreSubmitService storeSubmitService) {
        this.storeSubmitService = storeSubmitService;
    }

    // 店舗ページ表示
    @GetMapping("/mystore/{id}")
    public String mystoreEdit(@PathVariable Integer id, Model model) {
        Optional<Store> storeOpt = storeSubmitService.findById(id);
        Optional<IdSale> saleOpt = storeSubmitService.editSale(id);
        if(storeOpt.isEmpty()) {
            return "redirect:/mystore";
        }
        Store store = storeOpt.get();
        IdSale sale = saleOpt.get();
        StoreForm form = new StoreForm();
        IdSale saleform = new IdSale();
        form.setAddress(store.getAddress());
        form.setEmail(store.getEmail());
        form.setName(store.getName());
        form.setPhone_number(store.getPhone_number());
        form.setPayment(store.getPayment());
        if(store.getPrice_range() == null) {
            form.setPrice_range(0);
        } else {
            form.setPrice_range(store.getPrice_range());
        }
        form.setGenre(store.getGenre());
        form.setCoupon(store.getCoupon());
        form.setFree_desc(store.getFree_desc());
        saleform.setName(sale.getName());
        saleform.setContents(sale.getContents());
        model.addAttribute("StoreForm", form);
        model.addAttribute("Storeid", id);
        List<Email> email = storeSubmitService.previewEmail(id);
        model.addAttribute("email", email);
        model.addAttribute("sale", saleform);
        return "mystore";
    }
    // @GetMapping("/Suddensale")
    // public String showsuddensalePage() {
    // return "dotachan/Suddensale";
    // }

    //店舗編集
    @PostMapping("/mystore/{id}")
    public String updateStore(@PathVariable Integer id, @ModelAttribute StoreForm form) {
        storeSubmitService.updateStore(id, form);
        return "redirect:/mystore/" + id; 
    }

    // @PostMapping("/mystore/{id}")
    // public String mystorereEdit(@PathVariable Integer id, Model model) {
    //     List<Store> storeOpt = storeSubmitService.findById(id);
    //     if(storeOpt.isEmpty()) {
    //         return "redirect:/mystore";
    //     }
    //     Store store = storeOpt.get(id);
    //     StoreForm form = new StoreForm();
    //     form.setAddress(store.getAddress());
    //     form.setEmail(store.getEmail());
    //     form.setName(store.getName());
    //     form.setPhone_number(store.getPhone_number());
    //     form.setPayment(store.getPayment());
    //     if(store.getPrice_range() == null) {
    //         form.setPrice_range(0);
    //     } else {
    //         form.setPrice_range(store.getPrice_range());
    //     }
    //     form.setGenre(store.getGenre());
    //     form.setCoupon(store.getCoupon());
    //     form.setFree_desc(store.getFree_desc());
    //     model.addAttribute("StoreForm", form);
    //     model.addAttribute("Storeid", id);
    //     return "mystore";
    // }

    // 恒常セール編集機能
    @PostMapping("/sale/{id}")
    public String updateSale(@PathVariable Integer id, @ModelAttribute SaleForm form) {
        storeSubmitService.updateSale(id, form);
        return "redirect:/mystore/" + id;
    }

    // 突発セール編集機能
    // @PostMapping("/suddensale")
    // public String updateSuddenSale(@PathVariable Long id, @ModelAttribute
    // SuddenSaleForm form) {
    // storeSubmitService.updateSuddenSale(id, form);
    // return "redirect:/store";
    // }

    // @Autowired
    // private StoreSubmitService StoreSubmitService;

    //突発セール表示
    @GetMapping("/saleedit/{id}")
    public String showSuddensale(@PathVariable Integer id, Model model) {
        List<SuddenSaleview> suddensale = storeSubmitService.previewSuddenSaleForstoreId(id);
        model.addAttribute("suddensale", suddensale);
        // model.addAttribute("suddensaleList", storeSubmitService.showSuddensale());
        return "saleedit";
    }

    //突発セール登録
    @PostMapping("/suddensalereg/{id}")
    public String updateSuddenSale(@PathVariable Integer id, @ModelAttribute SuddenSaleForm form) {
        storeSubmitService.updateSuddenSale(id, form);
        return "redirect:/saleedit/" + id;
    }

    //突発セール完了切り替え
    @PostMapping("/saleedit/switch/{store_id}")
    public String switchSuddenSale(@RequestParam Integer id) {
        storeSubmitService.switchSuddenSale(id);
        return "redirect:/saleedit/" + id;
    }

}
