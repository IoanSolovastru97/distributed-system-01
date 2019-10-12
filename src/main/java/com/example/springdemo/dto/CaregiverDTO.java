package com.example.springdemo.dto;

import com.example.springdemo.entities.Patient;

import java.util.List;

public class CaregiverDTO {

    private String username;
    private List<Patient> patients;

    public CaregiverDTO(String username, List<Patient> patients) {
        this.username = username;
        this.patients = patients;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
