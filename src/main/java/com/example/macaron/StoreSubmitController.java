package com.example.macaron;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StoreSubmitController {
    private final StoreSubmitService storeSubmitService;

public StoreSubmitController(StoreSubmitService storeSubmitService){
    this.storeSubmitService = storeSubmitService;
}
@PostMapping("/mystore/register")
public String register(
    @RequestParam("email") String email,
    @RequestParam("name") String name,
    @RequestParam("address") String address,
    @RequestParam("phone_number") int phone_number,
    @RequestParam("payment") String payment,
    @RequestParam("genre") String genre,
    @RequestParam("price_range") int price_range,
    @RequestParam("free_desc") String free_desc,
  
) {

    return entity;
}

}