package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.entities.Doctor;
import com.example.springdemo.entities.MedicalRecord;
import com.example.springdemo.entities.Patient;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DoctorBuilder {

    public static DoctorDTO generateDTOFromEntity(Doctor doctor) {
        if (doctor.getPatients() == null) {
            doctor.setPatients(new ArrayList<Patient>());
        }
        if (doctor.getMedicalRecords() == null) {
            doctor.setMedicalRecords(new ArrayList<MedicalRecord>());
        }
        return new DoctorDTO(
                doctor.getUsername(),
                doctor.getPassword(), doctor.getName(),
                doctor.getGender(), doctor.getBirthday(),
                doctor.getAddress(),
                doctor.getPatients().stream().map(PatientBuilder::generateDTOFromEntity).collect(Collectors.toList()),
                doctor.getMedicalRecords().stream().map(MedicalRecordBuilder::generateDTOFromEntity).collect(Collectors.toList()));
    }

    public static Doctor generateEntityFromDTO(DoctorDTO doctorDTO) {
        if (doctorDTO.getMedicalRecords() == null) {
            doctorDTO.setMedicalRecords(new ArrayList<MedicalRecordDTO>());
        }
        if (doctorDTO.getPatients() == null) {
            doctorDTO.setPatients(new ArrayList<PatientDTO>());
        }
        return new Doctor(
                doctorDTO.getUsername(),
                doctorDTO.getPassword(),
                doctorDTO.getName(),
                doctorDTO.getGender(),
                doctorDTO.getBirthday(),
                doctorDTO.getAddress(),
                doctorDTO.getPatients().stream().map(PatientBuilder::generateEntityFromDTO).collect(Collectors.toList()),
                doctorDTO.getMedicalRecords().stream().map(MedicalRecordBuilder::generateEntityFromDTO).collect(Collectors.toList()));
    }
}
