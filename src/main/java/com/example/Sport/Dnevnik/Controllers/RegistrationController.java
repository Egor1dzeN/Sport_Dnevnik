package com.example.Sport.Dnevnik.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String getReg() {
        return "registration";
    }
    @PostMapping("/reg")
    public String postReg(@RequestParam String name,@RequestParam String email, Model model){
        System.out.println(name);
        System.out.println("oaos");
        return "redirect:/";
    }
}
