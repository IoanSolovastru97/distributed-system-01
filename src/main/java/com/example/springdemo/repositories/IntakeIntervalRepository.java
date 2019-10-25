package com.example.springdemo.repositories;

import com.example.springdemo.entities.IntakeInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntakeIntervalRepository extends JpaRepository<IntakeInterval, Integer> {
    @Query(value = "SELECT u " +
            "FROM intake_interval u " +
            "ORDER BY u.start_interval")
    List<IntakeInterval> getAllOrdered();
}
