package com.example.springdemo.entities;

import com.example.springdemo.entities.helper.Gender;
import com.example.springdemo.entities.helper.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "username")
@Table(name = "patient")
public class Patient extends User {

    @Column(name = "medical_records")
    @OneToMany
    private List<MedicalRecord> medicalRecords;

    public Patient(String username, String password, Role role) {
        super(username, password, role);
    }

    public Patient(String username, String password, String name, Gender gender, String birthday, String address, List<MedicalRecord> medicalRecords) {
        super(username, password, name, gender, birthday, address, Role.PATIENT);
        this.medicalRecords = medicalRecords;
    }

    public Patient() {
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
