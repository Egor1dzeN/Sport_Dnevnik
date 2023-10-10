package com.example.Sport.Dnevnik.Repositories;

import com.example.Sport.Dnevnik.Entity.Group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupsRepository extends JpaRepository<Group, Long> {
}
