package com.example.Sport.Dnevnik.Repositories;

import com.example.Sport.Dnevnik.Entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
