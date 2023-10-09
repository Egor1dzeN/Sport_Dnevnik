package com.example.Sport.Dnevnik.Controllers;

import com.example.Sport.Dnevnik.Entity.User;
import com.example.Sport.Dnevnik.service.MailSender;
import com.example.Sport.Dnevnik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    MailSender mailSender;

    @GetMapping("/reg")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String email, @RequestParam String username,@RequestParam String ps1,@RequestParam String ps2, Model model) {
        String error = "";
        if (!ps1.equals(ps2)){
            error = "Пароли не совпадают";
            model.addAttribute("error", error);
            return "registration";
        }
        User user = new User(username,ps1);
        user.setEmail(email);
        String activationCode = UUID.randomUUID().toString();
        user.setActivationCode(activationCode);
        System.out.println(activationCode);
        user.setPreviewImageId(1L);
        if (!userService.saveUser(user)){
            error = "Пользователь с таким именем уже существует";
            model.addAttribute("error", error);
            return "registration";
        }
        else {
            String subject = "Подтверждение почты для Sport_Dnevnik";
            String message = "Здравствуйте, подтвердите вашу почту нна сайте Sport_Dnevnik для того, чтобы продолжить действия...\n\n" +
                    "Перейдите по ссылке: "+"http://localhost:8080/activate/"+activationCode+"\n\n";

            mailSender.send(email, subject, message);
        }

        return "redirect:/";
    }
}
