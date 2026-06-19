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

    @GetMapping("/mystore")
    public String showmystorePage() {
        return "dotachan/mystore";
    }

    @GetMapping("/Suddensale")
    public String showsuddensalePage() {
        return "dotachan/saleedit";
    }

    @PostMapping("/store/{id}")
    public String updateStore(@PathVariable Long id, @ModelAttribute StoreForm form) {
        storeSubmitService.updateStore(id, form);
        return "redirect:/mystore";
    }

    @PostMapping("/sale/{id}")
    public String updateSale(@PathVariable Long id, @ModelAttribute SaleForm form) {
        storeSubmitService.updateSale(id, form);
        return "redirect:/mystore";
    }

    @PostMapping("/suddensale/{id}")
    public String updateSuddenSale(@PathVariable Long id, @ModelAttribute SuddenSaleForm form) {
        storeSubmitService.updateSuddenSale(id, form);
        return "redirect:/saleedit";
    }

    @Autowired
    private StoreSubmitService StoreSubmitService;

    @GetMapping("/suddensale")
    public String showSuddensale(Model model) {
        model.addAttribute("Suddensale", StoreSubmitService.showSuddensale());
        return "saleedit";
    }

    @PostMapping("/suddensale/switch")
    public String switchSuddenSale(@RequestParam("id") Long id) {
        StoreSubmitService.switchSuddenSale(id);
        return "redirect:/suddensale";
    }

    // @Autowired
    // private SuddensaleService suddensaleService;

    // @GetMapping("/suddensale")
    // public String showSuddensale(Model model) {
    // List<Suddensale> list = suddensaleService.findAll();
    // model.addAttribute("Suddensale", list);
    // return "suddensale";
    // }
}
