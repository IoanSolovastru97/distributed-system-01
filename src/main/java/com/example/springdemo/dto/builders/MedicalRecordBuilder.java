package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.entities.MedicalRecord;

import java.util.stream.Collectors;

public class MedicalRecordBuilder {

    public static MedicalRecordDTO generateDTOFromEntity(MedicalRecord medicalRecord) {
        return new MedicalRecordDTO(
                medicalRecord.getPatient(),
                medicalRecord.getDoctor(),
                medicalRecord.getPeriod(),
                medicalRecord.getDrugs().stream().map(DrugBuilder::generateDTOFromEntityWithId).collect(Collectors.toList()),
                medicalRecord.getIntakeIntervals().stream().map(IntakeIntervalBuilder::generateDTOFromEntityWithId).collect(Collectors.toList()));
    }

    public static MedicalRecord generateEntityFromDTO(MedicalRecordDTO medicalRecordDTO) {
        return new MedicalRecord(
                medicalRecordDTO.getPatient(),
                medicalRecordDTO.getDoctor(),
                medicalRecordDTO.getDrugs().stream().map(DrugBuilder::generateEntityFromDTOWithId).collect(Collectors.toList()),
                medicalRecordDTO.getPeriod(),
                medicalRecordDTO.getIntakeIntervals().stream().map(IntakeIntervalBuilder::generateEntityFromDTOWithId).collect(Collectors.toList()));
    }
}
