package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.entities.Patient;

public class PatientBuilder {

    public static PatientDTO generateDTOFromEntity(Patient patient) {
        return new PatientDTO(
                patient.getUsername(),
                patient.getPassword(),
                patient.getName(),
                patient.getGender(),
                patient.getBirthday(),
                patient.getAddress(),
                patient.getMedicalRecords());
    }

    public static Patient generateEntityFromDTO(PatientDTO patientDTO) {
        return new Patient(
                patientDTO.getUsername(),
                patientDTO.getPassword(),
                patientDTO.getName(),
                patientDTO.getGender(),
                patientDTO.getBirthday(),
                patientDTO.getAddress(),
                patientDTO.getMedicalRecords());
    }
}
