package com.example.macaron;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/keySerch")
    public String keySerch(@RequestParam String keySerch, Model model) {
        model.addAttribute("blog", ViewService.keySerch(keySerch));
        return "home";
    }
}
