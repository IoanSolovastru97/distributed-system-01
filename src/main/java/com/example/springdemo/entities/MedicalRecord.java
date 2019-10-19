package com.example.springdemo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medical_record")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @Column(name = "period")
    private String period;

    @Column(name = "drugs")
    @OneToMany
    private List<Drug> drugs;

    @Column(name = "intake_intervals")
    @OneToMany
    private List<IntakeInterval> intakeIntervals;

    public MedicalRecord(Patient patient, Doctor doctor, List<Drug> drugs, String period, List<IntakeInterval> intakeIntervals) {
        this.patient = patient;
        this.doctor = doctor;
        this.drugs = drugs;
        this.period = period;
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

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<IntakeInterval> getIntakeIntervals() {
        return intakeIntervals;
    }

    public void setIntakeIntervals(List<IntakeInterval> intakeIntervals) {
        this.intakeIntervals = intakeIntervals;
    }
}
