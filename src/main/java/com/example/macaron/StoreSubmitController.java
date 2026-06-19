package com.example.macaron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
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
    @GetMapping("/mystore")
    public String showmystorePage() {
        return "dotachan/mystore";
    }

    @GetMapping("/mystore/{id}")
    public String showmystorePage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "dotachan/mystore";
    }

    // @GetMapping("/store/{id}/edit")
    // public String editForm(@PathVariable Long id, Model model) {
    //     Optional<Store> bookOpt = StoreSubmitService.findById(id);
    //     if (storeOpt.isEmpty()) {
    //         return "redirect:/store";
    //     }
    //     Store store = storeOpt.get();

    //     StoreForm form = new StoreForm();
    //     form.setTitle(store.getTitle());
    //     form.setPrice(store.getPrice());
    //     model.addAttribute("storeForm", form);
    //     model.addAttribute("storeId", id);
    //     return "store/edit";
    // }

    // 突発セール編集ページ表示
    @GetMapping("/saleedit")
    public String showsaleeditPage() {
        return "dotachan/saleedit";
    }

    // 店舗編集機能
    @PostMapping("/store/{id}")
    public String updateStore(@PathVariable Long id, @ModelAttribute StoreForm form) {
        storeSubmitService.updateStore(id, form);
        return "redirect:/store" + id;
    }

    // 恒常セール編集機能
    @PostMapping("/sale/{id}")
    public String updateSale(@PathVariable Long id, @ModelAttribute SaleForm form) {
        storeSubmitService.updateSale(id, form);
        return "redirect:/store" + id;
    }

    // 突発セール編集機能
    @PostMapping("/suddensale")
    public String updateSuddenSale(@PathVariable Long id, @ModelAttribute SuddenSaleForm form) {
        storeSubmitService.updateSuddenSale(id, form);
        return "redirect:/store" + id;
    }

    @Autowired
    private StoreSubmitService StoreSubmitService;

    @GetMapping("/suddensale")
    public String showSuddensale(Model model) {
        model.addAttribute("suddensale", StoreSubmitService.showSuddensale());
        return "saleedit";
    }

    @PostMapping("/suddensale/switch")
    public String switchSuddenSale(@RequestParam("id") Long id) {
        StoreSubmitService.switchSuddenSale(id);
        return "redirect:/suddensale/1";
    }

}
