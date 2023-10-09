package com.example.Sport.Dnevnik.Repositories;

import com.example.Sport.Dnevnik.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByUsername(String username);
    User findUserByEmail(String email);
    User findAllByEmail(String email);
}
