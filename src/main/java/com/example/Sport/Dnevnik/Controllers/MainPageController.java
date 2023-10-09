package com.example.Sport.Dnevnik.Controllers;


import com.example.Sport.Dnevnik.Entity.User;
import com.example.Sport.Dnevnik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String mainPage(Model model){
//        User user = userService.is_login();
//        System.out.println(user);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)){
            User user = userService.is_login();
            model.addAttribute("name", user.getUsername());
            return "main_login";
        }
        return "main_no_login";
    }
}
