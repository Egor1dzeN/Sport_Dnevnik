package com.example.Sport.Dnevnik.Controllers;


import com.example.Sport.Dnevnik.Entity.Training;
import com.example.Sport.Dnevnik.Entity.User;
import com.example.Sport.Dnevnik.Repositories.TrainingRepository;
import com.example.Sport.Dnevnik.service.UserService;
import org.jboss.jandex.TypeTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonalAccountController {
    @Autowired
    UserService userService;
    @Autowired
    TrainingRepository trainingRepository;
    @GetMapping("/account/{id}")
    public String pesonal_account(@PathVariable String id, Model model){
        User user = userService.is_login();
        model.addAttribute("username", user.getUsername());
        List<Training> list_trainings = trainingRepository.findAllByUserId(Long.valueOf(id));
        System.out.println(list_trainings.size());
        model.addAttribute("trainings", list_trainings);
        if(id.equals(String.valueOf(user.getId()))){

            return "PersonalAccount";
        }
        else {

            return "OtherAccount";
        }


    }
}
