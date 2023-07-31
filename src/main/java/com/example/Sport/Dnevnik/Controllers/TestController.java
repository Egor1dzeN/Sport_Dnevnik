package com.example.Sport.Dnevnik.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String test_html(Model model){
        model.addAttribute("test","opaoapoap");
        return "test";
    }
}
