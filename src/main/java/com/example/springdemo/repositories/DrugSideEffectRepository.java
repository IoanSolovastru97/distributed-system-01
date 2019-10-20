package com.example.springdemo.repositories;

import com.example.springdemo.entities.DrugSideEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugSideEffectRepository extends JpaRepository<DrugSideEffect, Integer> {
}
