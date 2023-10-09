package com.example.Sport.Dnevnik.Controllers;


import com.example.Sport.Dnevnik.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ActivationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/activate/{code}")
    public String activationPerson(@PathVariable String code, Model model){
        System.out.println(code);
        return "redirect:/";
    }
}
