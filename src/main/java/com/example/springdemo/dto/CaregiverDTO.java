package com.example.springdemo.dto;

import com.example.springdemo.entities.Patient;
import com.example.springdemo.entities.helper.Gender;
import com.example.springdemo.entities.helper.Role;

import java.util.List;

public class CaregiverDTO extends UserDTO {

    private List<Patient> patients;

    public CaregiverDTO(String username, String password, String name, Gender gender, String birthday, String address, List<Patient> patients) {
        super(username, password, name, gender, birthday, address, Role.CAREGIVER);
        this.patients = patients;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
