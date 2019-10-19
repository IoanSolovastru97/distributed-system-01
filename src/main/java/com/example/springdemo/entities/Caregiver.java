package com.example.springdemo.entities;

import com.example.springdemo.entities.helper.Gender;
import com.example.springdemo.entities.helper.Profile;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "username")
@Table(name = "caregiver")
public class Caregiver extends User {

    @ManyToMany
    private List<Patient> patients;

    public Caregiver(List<Patient> patients) {
        this.patients = patients;
    }

    public Caregiver(String username, String password, String name, Gender gender, String birthday, String address, Profile profile, List<Patient> patients) {
        super(username, password, name, gender, birthday, address, profile);
        this.patients = patients;
    }

    public Caregiver(String username, String password, Profile profile, List<Patient> patients) {
        super(username, password, profile);
        this.patients = patients;
    }

    public List<Patient> getPatientList() {
        return patients;
    }

    public void setPatientList(List<Patient> patients) {
        this.patients = patients;
    }
}
