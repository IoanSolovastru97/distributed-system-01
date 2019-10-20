package com.example.springdemo.dto;

import com.example.springdemo.entities.MedicalRecord;
import com.example.springdemo.entities.helper.Gender;
import com.example.springdemo.entities.helper.Profile;

import java.util.List;

public class PatientDTO extends UserDTO {
    private List<MedicalRecord> medicalRecords;

    public PatientDTO(String username, String password, String name, Gender gender, String birthday, String address, Profile profile, List<MedicalRecord> medicalRecords) {
        super(username, password, name, gender, birthday, address, profile);
        this.medicalRecords = medicalRecords;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
