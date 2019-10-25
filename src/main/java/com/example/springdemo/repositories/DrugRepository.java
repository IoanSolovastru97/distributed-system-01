package com.example.springdemo.repositories;

import com.example.springdemo.entities.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Integer> {
    @Query(
            value = "SELECT * FROM drug ORDER BY name",
            nativeQuery = true)
    List<Drug> getAllOrdered();
}
