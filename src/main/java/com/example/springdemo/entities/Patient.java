package com.example.springdemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;


}
