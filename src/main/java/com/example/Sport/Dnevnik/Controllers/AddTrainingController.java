package com.example.Sport.Dnevnik.Controllers;

import com.example.Sport.Dnevnik.Entity.Training;
import com.example.Sport.Dnevnik.Entity.User;
import com.example.Sport.Dnevnik.Repositories.TrainingRepository;
import com.example.Sport.Dnevnik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @PostMapping("/add_training")
    public String add_training_post(@RequestParam(name = "name_training") String name_training,
                                    @RequestParam(name = "description") String description,
                                    @RequestParam(name = "distance") String distance,
                                    @RequestParam("duration")@DateTimeFormat(iso =DateTimeFormat.ISO.TIME)String stringduration,
                                    @RequestParam("date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)String stringdate
                                    ) throws ParseException {
        User user = userService.is_login();
//        System.out.println(stringdate);
        System.out.println(stringduration);
        DateFormat durationFormat = new SimpleDateFormat("HH:mm:ss");
        Date duration = durationFormat.parse(stringduration);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse(stringdate);
        System.out.println(duration);
        System.out.println(date1);
        Training training = new Training(user,duration,date1, name_training, description, Double.parseDouble(distance));
        trainingRepository.save(training);
        System.out.println("Add training: User = "+user.getUsername()+" "+name_training+" "+ description+" "+ distance);
        return "redirect:/add_training";
    }
}
