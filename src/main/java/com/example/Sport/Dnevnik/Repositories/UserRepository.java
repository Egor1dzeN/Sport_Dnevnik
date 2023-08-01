package com.example.Sport.Dnevnik.Repositories;

import com.example.Sport.Dnevnik.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByUsername(String username);
}
