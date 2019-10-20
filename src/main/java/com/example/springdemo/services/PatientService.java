package com.example.springdemo.services;

import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.builders.MedicalRecordBuilder;
import com.example.springdemo.dto.builders.PatientBuilder;
import com.example.springdemo.entities.MedicalRecord;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.PatientRepository;
import com.example.springdemo.validators.UserFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientDTO findById(String id) {
        Optional<Patient> patient = patientRepository.findById(id);

        if (!patient.isPresent()) {
            throw new ResourceNotFoundException("Patient", "patient id", id);
        }
        return PatientBuilder.generateDTOFromEntity(patient.get());
    }

    public List<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public String insert(PatientDTO patientDTO) {
        UserFieldValidator.validateInsertOrUpdate(patientDTO);
        return patientRepository
                .save(PatientBuilder.generateEntityFromDTO(patientDTO))
                .getUsername();
    }

    public String update(PatientDTO patientDTO) {
        Optional<Patient> patient = patientRepository.findById(patientDTO.getUsername());

        if (!patient.isPresent()) {
            throw new ResourceNotFoundException("Patient", "patient id", patientDTO.getUsername());
        }
        UserFieldValidator.validateInsertOrUpdate(patientDTO);

        return patientRepository.save(PatientBuilder.generateEntityFromDTO(patientDTO)).getUsername();
    }

    public void delete(PatientDTO patientViewDTO) {
        this.patientRepository.deleteById(patientViewDTO.getUsername());
    }

    public List<MedicalRecordDTO> getMedicalRecords(String id) {
        Optional<Patient> patient = patientRepository.findById(id);

        if (!patient.isPresent()) {
            throw new ResourceNotFoundException("Patient", "patient id", id);
        }

        List<MedicalRecord> medicalRecords = patient.get().getMedicalRecords();
        return medicalRecords.stream().
                map(MedicalRecordBuilder::generateDTOFromEntity).
                collect(Collectors.toList());
    }
}
