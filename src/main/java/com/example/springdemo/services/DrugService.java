package com.example.springdemo.services;

import com.example.springdemo.dto.DrugDTO;
import com.example.springdemo.dto.builders.DrugBuilder;
import com.example.springdemo.entities.Drug;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DrugService {

    @Autowired
    private DrugRepository drugRepository;

    public DrugDTO findById(Integer id) {
        Optional<Drug> drug = drugRepository.findById(id);

        if (!drug.isPresent()) {
            throw new ResourceNotFoundException("Intake interval", "drug id", id);
        }
        return DrugBuilder.generateDTOFromEntityWithId(drug.get());
    }

    public List<DrugDTO> findAll() {
        List<Drug> drugs = drugRepository.getAllOrdered();

        return drugs.stream()
                .map(DrugBuilder::generateDTOFromEntityWithId)
                .collect(Collectors.toList());
    }

    public Integer insert(DrugDTO drugDTO) {
        return drugRepository
                .save(DrugBuilder.generateEntityFromDTO(drugDTO))
                .getId();
    }

    public void delete(DrugDTO drugDTO) {
        Optional<Drug> drug = drugRepository.findById(drugDTO.getId());

        if (!drug.isPresent()) {
            throw new ResourceNotFoundException("Intake", "intake id", drugDTO.getId());
        }
        drugRepository.deleteById(DrugBuilder.generateEntityFromDTO(drugDTO).getId());
    }
}
