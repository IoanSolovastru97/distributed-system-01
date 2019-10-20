package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.entities.Doctor;

public class DoctorBuilder {

    public static DoctorDTO generateDTOFromEntity(Doctor doctor) {
        return new DoctorDTO(
                doctor.getUsername(),
                doctor.getPassword(), doctor.getName(),
                doctor.getGender(), doctor.getBirthday(),
                doctor.getAddress(),
                doctor.getPatients(),
                doctor.getMedicalRecords());
    }

    public static Doctor generateEntityFromDTO(DoctorDTO doctorDTO) {
        return new Doctor(
                doctorDTO.getUsername(),
                doctorDTO.getPassword(),
                doctorDTO.getName(),
                doctorDTO.getGender(),
                doctorDTO.getBirthday(),
                doctorDTO.getAddress(),
                doctorDTO.getPatients(),
                doctorDTO.getMedicalRecords());
    }
}
