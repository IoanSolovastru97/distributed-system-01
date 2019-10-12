package com.example.springdemo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "caregiver")
public class Caregiver {

    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Patient> patients;

    public Caregiver(String username) {
        this.username = username;
    }

    public Caregiver(String username, List<Patient> patients) {
        this.username = username;
        this.patients = patients;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Patient> getPatientList() {
        return patients;
    }

    public void setPatientList(List<Patient> patients) {
        this.patients = patients;
    }
}
