package com.example.Sport.Dnevnik.Repositories;

import com.example.Sport.Dnevnik.Entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    Training findByUserId(Long id);
    List<Training> findAllByUserId(Long id);
}
