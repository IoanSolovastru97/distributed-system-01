package com.example.springdemo.dto;

public class DrugDTO {

    private Integer id;
    private String name;
    private String description;
    private DrugSideEffectDTO drugSideEffect;

    public DrugDTO(String name, String description, DrugSideEffectDTO drugSideEffect) {
        this.name = name;
        this.description = description;
        this.drugSideEffect = drugSideEffect;
    }

    public DrugDTO(Integer id, String name, String description, DrugSideEffectDTO drugSideEffect) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.drugSideEffect = drugSideEffect;
    }

    public DrugDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DrugSideEffectDTO getDrugSideEffect() {
        return drugSideEffect;
    }

    public void setDrugSideEffect(DrugSideEffectDTO drugSideEffect) {
        this.drugSideEffect = drugSideEffect;
    }
}
