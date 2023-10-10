package com.example.Sport.Dnevnik.Controllers;

import com.example.Sport.Dnevnik.Entity.Group.Group;
import com.example.Sport.Dnevnik.Entity.Group.User_groups;
import com.example.Sport.Dnevnik.Entity.User;
import com.example.Sport.Dnevnik.Repositories.GroupsRepository;
import com.example.Sport.Dnevnik.Repositories.User_GroupRepository;
import com.example.Sport.Dnevnik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GroupController {
    @Autowired
    GroupsRepository groupsRepository;
    @Autowired
    UserService userService;
    @Autowired
    User_GroupRepository userGroupRepository;


    @GetMapping("/group")
    public String get_group(Model model){
        User user = userService.is_login();
        List<Group> list_groups = groupsRepository.findAll();
        for(int  i =0;i<list_groups.size();++i){
            User_groups userGroups = userGroupRepository.findAllByGroupIdAndUserId(list_groups.get(i).getId(), user.getId());
            int status = userGroups == null?0:userGroups.getStatus();
            list_groups.get(i).setStatus(status);
        }
        model.addAttribute("list_groups", list_groups);
        return "groups";
    }
    @GetMapping("/create_group")
    public String create_group(){

        return "create_group";
    }
    @PostMapping("/create_group")
    public String create_group_post(@RequestParam String name_group,
                                    @RequestParam String description){
        Group group = new Group(name_group, description);
        groupsRepository.save(group);
        User user = userService.is_login();
        User_groups userGroups = new User_groups(user, group, 3);
        userGroupRepository.save(userGroups);

        return "redirect:/group";

    }

}
