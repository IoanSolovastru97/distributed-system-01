package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.IntakeIntervalDTO;
import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.entities.IntakeInterval;
import com.example.springdemo.soap.Interval;

import java.math.BigDecimal;

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

    public static IntakeIntervalDTO generateDTOFromEntityWithId(IntakeInterval intakeInterval) {
        return new IntakeIntervalDTO(
                intakeInterval.getId(),
                intakeInterval.getStartInterval(),
                intakeInterval.getEndInterval());
    }

    public static IntakeInterval generateEntityFromDTOWithId(IntakeIntervalDTO intakeIntervalDTO) {
        return new IntakeInterval(
                intakeIntervalDTO.getId(),
                intakeIntervalDTO.getStartInterval(),
                intakeIntervalDTO.getEndInterval());
    }

    public static com.example.springdemo.soap.Interval generateDTOToSoap(IntakeIntervalDTO intakeIntervalDTO) {
        Interval interval = new Interval();
        interval.setId(BigDecimal.valueOf(intakeIntervalDTO.getId()));
        interval.setStartInterval(intakeIntervalDTO.getStartInterval());
        interval.setEndInterval(intakeIntervalDTO.getEndInterval());
        return interval;
    }

}
