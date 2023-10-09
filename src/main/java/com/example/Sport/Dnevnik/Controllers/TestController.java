package com.example.Sport.Dnevnik.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

//    @Autowired
//    MailSender mailSender;

    @GetMapping("/test")
    public String test_html(Model model){

        return "test";
    }
    @PostMapping("/test")
    public String send_Email(@RequestParam String email){
        System.out.println(email);
        //mailSender.send(email, "Subject","HEloo");
        return "redirect:/test";
    }
}
