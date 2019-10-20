package com.example.springdemo.dto;

import com.example.springdemo.entities.Doctor;
import com.example.springdemo.entities.Drug;
import com.example.springdemo.entities.IntakeInterval;
import com.example.springdemo.entities.Patient;

import java.util.List;

public class MedicalRecordDTO {

    private Integer id;
    private Patient patient;
    private Doctor doctor;
    private String period;
    private List<Drug> drugs;
    private List<IntakeInterval> intakeIntervals;

    public MedicalRecordDTO(Patient patient, Doctor doctor, String period, List<Drug> drugs, List<IntakeInterval> intakeIntervals) {
        this.patient = patient;
        this.doctor = doctor;
        this.period = period;
        this.drugs = drugs;
        this.intakeIntervals = intakeIntervals;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public List<IntakeInterval> getIntakeIntervals() {
        return intakeIntervals;
    }

    public void setIntakeIntervals(List<IntakeInterval> intakeIntervals) {
        this.intakeIntervals = intakeIntervals;
    }
}
