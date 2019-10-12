package com.example.springdemo.repositories;

import com.example.springdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT u " +
            "FROM User u " +
            "ORDER BY u.username")
    List<User> getAllOrdered();
}
