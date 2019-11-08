package com.example.springdemo.dto;

import com.example.springdemo.entities.helper.Gender;
import com.example.springdemo.entities.helper.Role;

import java.util.List;

public class DoctorDTO extends UserDTO {

    private List<PatientDTO> patients;
    private List<MedicalRecordDTO> medicalRecords;

    public DoctorDTO(String username, String password, String name, Gender gender, String birthday, String address, List<PatientDTO> patients, List<MedicalRecordDTO> medicalRecords) {
        super(username, password, name, gender, birthday, address, Role.DOCTOR);
        this.patients = patients;
        this.medicalRecords = medicalRecords;
    }

    public List<PatientDTO> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientDTO> patients) {
        this.patients = patients;
    }

    public List<MedicalRecordDTO> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecordDTO> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
