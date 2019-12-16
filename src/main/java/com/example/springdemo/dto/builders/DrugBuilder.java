package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.DrugDTO;
import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.entities.Drug;

import java.math.BigDecimal;

public class DrugBuilder {

    public static DrugDTO generateDTOFromEntity(Drug drug) {
        return new DrugDTO(
                drug.getName(),
                drug.getDescription(),
                DrugSideEffectBuilder.generateDTOFromEntity(drug.getDrugSideEffect()));
    }

    public static Drug generateEntityFromDTO(DrugDTO drugDTO) {
        return new Drug(
                drugDTO.getName(),
                drugDTO.getDescription(),
                DrugSideEffectBuilder.generateEntityFromDTO(drugDTO.getDrugSideEffect()));
    }

    public static DrugDTO generateDTOFromEntityWithId(Drug drug) {
        return new DrugDTO(
                drug.getId(),
                drug.getName(),
                drug.getDescription(),
                DrugSideEffectBuilder.generateDTOFromEntity(drug.getDrugSideEffect()));
    }

    public static Drug generateEntityFromDTOWithId(DrugDTO drugDTO) {
        return new Drug(
                drugDTO.getId(),
                drugDTO.getName(),
                drugDTO.getDescription(),
                DrugSideEffectBuilder.generateEntityFromDTO(drugDTO.getDrugSideEffect()));
    }

    public static com.example.springdemo.soap.Drug generateDTOToSoap(DrugDTO drugDTO) {
        com.example.springdemo.soap.Drug drug = new com.example.springdemo.soap.Drug();
        drug.setDescription(drugDTO.getDescription());
        drug.setName(drugDTO.getName());
        drug.setId(BigDecimal.valueOf(drugDTO.getId()));
        //TODO add drug side effect
        return drug;
    }

}