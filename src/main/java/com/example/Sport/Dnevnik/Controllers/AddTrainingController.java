package com.example.Sport.Dnevnik.Controllers;

import com.example.Sport.Dnevnik.Entity.User;
import com.example.Sport.Dnevnik.Repositories.TrainingRepository;
import com.example.Sport.Dnevnik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddTrainingController {
    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    UserService userService;

    @GetMapping("/add_training")
    public String add_training(Model model){

        return "add_training";
    }
}
