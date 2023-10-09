package com.example.Sport.Dnevnik.service;

import com.example.Sport.Dnevnik.Entity.Role;
import com.example.Sport.Dnevnik.Entity.User;
import com.example.Sport.Dnevnik.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class UserService  implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        System.out.println("!!!!");
        //System.out.println(email);
        User myuser = userRepository.findAllByUsername(username);

        if(myuser == null) {
            System.out.println("!!sda "+username);
            System.out.println("No found");
            throw new UsernameNotFoundException("User not found");

        }
        System.out.println(myuser.getUsername());
        return myuser;
    }

    public boolean saveUser(User user){
        User userFromDB = userRepository.findAllByUsername(user.getUsername());
        if(userFromDB != null)
            return false;
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
    public User is_login(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        return userRepository.findAllByUsername(userDetails.getUsername());
    }
}
