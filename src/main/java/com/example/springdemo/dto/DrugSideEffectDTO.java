package com.example.springdemo.dto;

import com.example.springdemo.entities.DrugSideEffect;

public class DrugSideEffectDTO {

    private Integer id;
    private String description;

    public DrugSideEffectDTO(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
