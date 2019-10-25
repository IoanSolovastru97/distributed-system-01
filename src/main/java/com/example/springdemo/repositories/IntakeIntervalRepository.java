package com.example.springdemo.repositories;

import com.example.springdemo.entities.IntakeInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntakeIntervalRepository extends JpaRepository<IntakeInterval, Integer> {
    @Query(
            value = "SELECT * FROM intake_interval ORDER BY start_interval",
            nativeQuery = true)
    List<IntakeInterval> getAllOrdered();
}
