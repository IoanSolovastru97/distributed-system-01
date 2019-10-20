package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.entities.Caregiver;

public class CaregiverBuilder {

    public static CaregiverDTO generateDTOFromEntity(Caregiver caregiver) {
        return new CaregiverDTO(
                caregiver.getUsername(),
                caregiver.getPassword(), caregiver.getName(),
                caregiver.getGender(), caregiver.getBirthday(),
                caregiver.getAddress(), caregiver.getProfile(),
                caregiver.getPatientList());
    }

    public static Caregiver generateEntityFromDTO(CaregiverDTO caregiverDTO) {
        return new Caregiver(
                caregiverDTO.getUsername(),
                caregiverDTO.getPassword(),
                caregiverDTO.getName(),
                caregiverDTO.getGender(),
                caregiverDTO.getBirthday(),
                caregiverDTO.getAddress(),
                caregiverDTO.getProfile(),
                caregiverDTO.getPatients());
    }
}
