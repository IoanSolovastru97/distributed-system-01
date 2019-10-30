package com.example.springdemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "drug")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne
    private DrugSideEffect drugSideEffect;

    public Drug(String name, String description, DrugSideEffect drugSideEffect) {
        this.name = name;
        this.description = description;
        this.drugSideEffect = drugSideEffect;
    }

    public Drug(Integer id, String name, String description, DrugSideEffect drugSideEffect) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.drugSideEffect = drugSideEffect;
    }

    public Drug() {
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

    public DrugSideEffect getDrugSideEffect() {
        return drugSideEffect;
    }

    public void setDrugSideEffect(DrugSideEffect drugSideEffect) {
        this.drugSideEffect = drugSideEffect;
    }
}
