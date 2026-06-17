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

@Controller
public class StoreSubmitController {
    private final StoreSubmitService storeSubmitService;

    public StoreSubmitController(StoreSubmitService storeSubmitService) {
        this.storeSubmitService = storeSubmitService;
    }

    // @PostMapping("/mystore/register")
    // public String register(
    // @RequestParam("name") String name,
    // @RequestParam("address") String address,
    // @RequestParam("phone_number") int phone_number,
    // @RequestParam("payment") String payment,
    // @RequestParam("genre") String genre,
    // @RequestParam("price_range") int price_range,
    // @RequestParam("free_desc") String free_desc,
    // @RequestParam("coupon") String coupon) {
    // storeSubmitService.editstore(name, address, phone_number, payment, genre,
    // price_range, free_desc,
    // coupon);
    // return "redirect:/mystore";
    @PostMapping("/store/{id}")
    public String updateStore(@PathVariable Long id, @ModelAttribute StoreForm form) {
        storeSubmitService.updateStore(id, form);
        return "redirect:/store";
    }

    @PostMapping("/sale/{id}")
    public String updateSale(@PathVariable Long id, @ModelAttribute SaleForm form) {
        storeSubmitService.updateSale(id, form);
        return "redirect:/store";
    }

}
