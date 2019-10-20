package com.example.springdemo.repositories;

import com.example.springdemo.entities.IntakeInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntakeIntervalRepository extends JpaRepository<IntakeInterval, Integer> {
}
