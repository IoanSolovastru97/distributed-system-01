package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.entities.Patient;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CaregiverBuilder {

    public static CaregiverDTO generateDTOFromEntity(Caregiver caregiver) {
        if (caregiver.getPatientList() == null) {
            caregiver.setPatientList(new ArrayList<Patient>());
        }
        return new CaregiverDTO(
                caregiver.getUsername(),
                caregiver.getPassword(), caregiver.getName(),
                caregiver.getGender(), caregiver.getBirthday(),
                caregiver.getAddress(),
                caregiver.getPatientList().stream().map(PatientBuilder::generateDTOFromEntity).collect(Collectors.toList()));
    }

    public static Caregiver generateEntityFromDTO(CaregiverDTO caregiverDTO) {
        if (caregiverDTO.getPatients() == null) {
            caregiverDTO.setPatients(new ArrayList<PatientDTO>());
        }
        return new Caregiver(
                caregiverDTO.getUsername(),
                caregiverDTO.getPassword(),
                caregiverDTO.getName(),
                caregiverDTO.getGender(),
                caregiverDTO.getBirthday(),
                caregiverDTO.getAddress(),
                caregiverDTO.getPatients().stream().map(PatientBuilder::generateEntityFromDTO).collect(Collectors.toList()));
    }
}
