package com.example.springdemo.services;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.builders.CaregiverBuilder;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.CaregiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CaregiverService {

    @Autowired
    private CaregiverRepository caregiverRepository;

    public CaregiverDTO findCaregiverById(String id) {
        Optional<Caregiver> caregiver = caregiverRepository.findById(id);

        if (!caregiver.isPresent()) {
            throw new ResourceNotFoundException("Caregiver", "caregiver id", id);
        }
        return CaregiverBuilder.generateDTOFromEntity(caregiver.get());
    }

    public List<CaregiverDTO> findAll() {
        List<Caregiver> caregivers = caregiverRepository.getAllOrdered();

        return caregivers.stream()
                .map(CaregiverBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public List<Patient> findAllPatients(String id) {
        Optional<Caregiver> caregiver = caregiverRepository.findById(id);

        if (!caregiver.isPresent()) {
            throw new ResourceNotFoundException("Caregiver", "caregiver id", id);
        }

        return caregiver.get().getPatientList();
    }

    public String insert(CaregiverDTO caregiverDTO) {
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

}
