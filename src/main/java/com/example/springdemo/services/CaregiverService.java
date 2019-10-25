package com.example.springdemo.services;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.builders.CaregiverBuilder;
import com.example.springdemo.dto.builders.PatientBuilder;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.CaregiverRepository;
import com.example.springdemo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CaregiverService {

    @Autowired
    private CaregiverRepository caregiverRepository;
    @Autowired
    private PatientRepository patientRepository;

    public CaregiverDTO findCaregiverById(String id) {
        Optional<Caregiver> caregiver = caregiverRepository.findById(id);

        if (!caregiver.isPresent()) {
            throw new ResourceNotFoundException("Caregiver", "caregiver id", id);
        }
        return CaregiverBuilder.generateDTOFromEntity(caregiver.get());
    }

    public List<CaregiverDTO> findAll() {
        List<Caregiver> caregivers = caregiverRepository.findAll();

        return caregivers.stream()
                .map(CaregiverBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public List<PatientDTO> findAllPatients(String id) {
        Optional<Caregiver> caregiver = caregiverRepository.findById(id);

        if (!caregiver.isPresent()) {
            throw new ResourceNotFoundException("Caregiver", "caregiver id", id);
        }

        List<Patient> patients = caregiver.get().getPatientList();
        return patients.stream()
                .map(PatientBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public String insert(CaregiverDTO caregiverDTO) {
        caregiverDTO.setPassword(getPassword(caregiverDTO.getPassword()));
        return caregiverRepository
                .save(CaregiverBuilder.generateEntityFromDTO(caregiverDTO))
                .getUsername();
    }

    public String update(CaregiverDTO caregiverDTO) {
        Optional<Caregiver> caregiver = caregiverRepository.findById(caregiverDTO.getUsername());

        if (!caregiver.isPresent()) {
            throw new ResourceNotFoundException("Caregiver", "caregiver id", caregiverDTO.getUsername());
        }
        return caregiverRepository.save(CaregiverBuilder.generateEntityFromDTO(caregiverDTO)).getUsername();
    }

    public void delete(CaregiverDTO caregiverDTO) {
        Optional<Caregiver> caregiver = caregiverRepository.findById(caregiverDTO.getUsername());

        if (!caregiver.isPresent()) {
            throw new ResourceNotFoundException("Caregiver", "caregiver id", caregiverDTO.getUsername());
        }
        caregiverRepository.deleteById(CaregiverBuilder.generateEntityFromDTO(caregiverDTO).getUsername());
    }

    private String getPassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public String insertPatient(String patientId, String caregiverId){
        Optional<Patient> patient = patientRepository.findById(patientId);
        Optional<Caregiver> caregiver = caregiverRepository.findById(caregiverId);

        if (!patient.isPresent()) {
            throw new ResourceNotFoundException("Patient", "patient id", patientId);
        }
        if (!caregiver.isPresent()) {
            throw new ResourceNotFoundException("Caregiver", "caregiver id", caregiverId);
        }
        caregiver.get().getPatientList().add(patient.get());
        caregiverRepository.save(caregiver.get());
        return caregiverId;
    }

}
