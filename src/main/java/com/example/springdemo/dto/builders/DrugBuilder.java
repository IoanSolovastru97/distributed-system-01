package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.DrugDTO;
import com.example.springdemo.entities.Drug;

public class DrugBuilder {

    public static DrugDTO generateDTOFromEntity(Drug drug) {
        return new DrugDTO(
                drug.getName(),
                drug.getDescription(),
                drug.getDrugSideEffect());
    }

    public static Drug generateEntityFromDTO(DrugDTO drugDTO) {
        return new Drug(
                drugDTO.getName(),
                drugDTO.getDescription(),
                drugDTO.getDrugSideEffect());
    }
}
