package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.IntakeIntervalDTO;
import com.example.springdemo.entities.IntakeInterval;

public class IntakeIntervalBuilder {

    public static IntakeIntervalDTO generateDTOFromEntity(IntakeInterval intakeInterval) {
        return new IntakeIntervalDTO(
                intakeInterval.getStartInterval(),
                intakeInterval.getEndInterval());
    }

    public static IntakeInterval generateEntityFromDTO(IntakeIntervalDTO intakeIntervalDTO) {
        return new IntakeInterval(
                intakeIntervalDTO.getStartInterval(),
                intakeIntervalDTO.getEndInterval());
    }
}
