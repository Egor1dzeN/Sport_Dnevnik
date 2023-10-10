package com.example.Sport.Dnevnik.Repositories;

import com.example.Sport.Dnevnik.Entity.Group.User_groups;
import com.example.Sport.Dnevnik.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface User_GroupRepository extends JpaRepository<User_groups, Long> {
    User_groups findAllByGroupIdAndUserId(Long id, Long id1);
}
