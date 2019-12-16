package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.entities.MedicalRecord;
import com.example.springdemo.entities.Patient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PatientBuilder {

    public static PatientDTO generateDTOFromEntity(Patient patient) {
        if(patient.getMedicalRecords() == null){
            patient.setMedicalRecords(new ArrayList<MedicalRecord>());
        }
        return new PatientDTO(
                patient.getUsername(),
                patient.getPassword(),
                patient.getName(),
                patient.getGender(),
                patient.getBirthday(),
                patient.getAddress(),
                patient.getMedicalRecords().stream().map(MedicalRecordBuilder::generateDTOFromEntity).collect(Collectors.toList()));
    }

    public static Patient generateEntityFromDTO(PatientDTO patientDTO) {
        if(patientDTO.getMedicalRecords() == null){
            patientDTO.setMedicalRecords(new ArrayList<MedicalRecordDTO>());
        }
        return new Patient(
                patientDTO.getUsername(),
                patientDTO.getPassword(),
                patientDTO.getName(),
                patientDTO.getGender(),
                patientDTO.getBirthday(),
                patientDTO.getAddress(),
                patientDTO.getMedicalRecords().stream().map(MedicalRecordBuilder::generateEntityFromDTO).collect(Collectors.toList()));
    }

    public static com.example.springdemo.soap.Patient generateDTOToSoap(PatientDTO patientDTO) {
        com.example.springdemo.soap.Patient patient = new com.example.springdemo.soap.Patient();
        patient.setAddress(patientDTO.getAddress());
        patient.setBirthday(patientDTO.getBirthday());
        patient.setGender(patientDTO.getGender().toString());
        patient.setName(patientDTO.getName());
        patient.setRole(patientDTO.getRole().toString());
        patient.setUsername(patientDTO.getUsername());
        patient.setPassword(patientDTO.getPassword());
        return patient;
    }
}
