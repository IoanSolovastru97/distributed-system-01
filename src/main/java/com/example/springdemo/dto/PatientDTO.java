package com.example.springdemo.dto;

import com.example.springdemo.entities.helper.Gender;
import com.example.springdemo.entities.helper.Role;

import java.util.List;

public class PatientDTO extends UserDTO {
    private List<MedicalRecordDTO> medicalRecords;

    public PatientDTO(String username, String password, String name, Gender gender, String birthday, String address, List<MedicalRecordDTO> medicalRecords) {
        super(username, password, name, gender, birthday, address, Role.PATIENT);
        this.medicalRecords = medicalRecords;
    }

    public List<MedicalRecordDTO> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecordDTO> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
