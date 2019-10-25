package com.example.springdemo.services;

import com.example.springdemo.dto.IntakeIntervalDTO;
import com.example.springdemo.dto.builders.IntakeIntervalBuilder;
import com.example.springdemo.entities.IntakeInterval;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.IntakeIntervalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IntakeIntervalService {

    @Autowired
    private IntakeIntervalRepository intakeIntervalRepository;

    public IntakeIntervalDTO findById(Integer id) {
        Optional<IntakeInterval> intakeInterval = intakeIntervalRepository.findById(id);

        if (!intakeInterval.isPresent()) {
            throw new ResourceNotFoundException("Intake interval", "intakeInterval id", id);
        }
        return IntakeIntervalBuilder.generateDTOFromEntity(intakeInterval.get());
    }

    public List<IntakeIntervalDTO> findAll() {
        List<IntakeInterval> intakeIntervals = intakeIntervalRepository.getAllOrdered();

        return intakeIntervals.stream()
                .map(IntakeIntervalBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Integer insert(IntakeIntervalDTO intakeIntervalDTO) {
        return intakeIntervalRepository
                .save(IntakeIntervalBuilder.generateEntityFromDTO(intakeIntervalDTO))
                .getId();
    }

    public void delete(IntakeIntervalDTO intakeIntervalDTO) {
        Optional<IntakeInterval> intakeInterval = intakeIntervalRepository.findById(intakeIntervalDTO.getId());

        if (!intakeInterval.isPresent()) {
            throw new ResourceNotFoundException("Intake", "intake id", intakeIntervalDTO.getId());
        }
        intakeIntervalRepository.deleteById(IntakeIntervalBuilder.generateEntityFromDTO(intakeIntervalDTO).getId());
    }


}
