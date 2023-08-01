package com.example.Sport.Dnevnik.service;

import com.example.Sport.Dnevnik.Entity.User;
import com.example.Sport.Dnevnik.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService  implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findAllByUsername(username);

        if(user == null)
            throw  new UsernameNotFoundException("User not found");

        return (UserDetails) user;
    }
}
