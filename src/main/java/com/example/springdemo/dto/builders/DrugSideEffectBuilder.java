package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.DrugSideEffectDTO;
import com.example.springdemo.entities.DrugSideEffect;

public class DrugSideEffectBuilder {

    public static DrugSideEffectDTO generateDTOFromEntity(DrugSideEffect drugSideEffect) {
        return new DrugSideEffectDTO(
                drugSideEffect.getDescription());
    }

    public static DrugSideEffect generateEntityFromDTO(DrugSideEffectDTO drugSideEffectDTO) {
        return new DrugSideEffect(drugSideEffectDTO.getDescription());
    }
}
