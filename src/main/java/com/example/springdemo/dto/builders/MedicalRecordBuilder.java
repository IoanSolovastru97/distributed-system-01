package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.entities.MedicalRecord;

public class MedicalRecordBuilder {

    public static MedicalRecordDTO generateDTOFromEntity(MedicalRecord medicalRecord) {
        return new MedicalRecordDTO(
                medicalRecord.getPatient(),
                medicalRecord.getDoctor(),
                medicalRecord.getPeriod(),
                medicalRecord.getDrugs(),
                medicalRecord.getIntakeIntervals());
    }

    public static MedicalRecord generateEntityFromDTO(MedicalRecordDTO medicalRecordDTO) {
        return new MedicalRecord(
                medicalRecordDTO.getPatient(),
                medicalRecordDTO.getDoctor(),
                medicalRecordDTO.getDrugs(),
                medicalRecordDTO.getPeriod(),
                medicalRecordDTO.getIntakeIntervals());
    }
}
