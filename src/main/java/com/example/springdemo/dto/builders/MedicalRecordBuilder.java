package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.DoctorDTO;
import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.entities.MedicalRecord;
import com.example.springdemo.soap.Doctor;
import com.example.springdemo.soap.Patient;

import java.math.BigDecimal;
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

    public static com.example.springdemo.soap.Medicalrecord generateDTOToSoap(MedicalRecordDTO medicalRecordDTO) {
        com.example.springdemo.soap.Medicalrecord medicalrecord = new com.example.springdemo.soap.Medicalrecord();
        //TODO set Doctor and Patient
        medicalrecord.setDoctor(new Doctor());
        medicalrecord.setPatient(new Patient());
        medicalrecord.setPeriod(medicalRecordDTO.getPeriod());
        medicalrecord.getDrugs().addAll(medicalRecordDTO.getDrugs().stream().map(DrugBuilder::generateDTOToSoap).collect(Collectors.toList()));
        medicalrecord.getIntervals().addAll(medicalRecordDTO.getIntakeIntervals().stream().map(IntakeIntervalBuilder::generateDTOToSoap).collect(Collectors.toList()));
        return medicalrecord;
    }
}
