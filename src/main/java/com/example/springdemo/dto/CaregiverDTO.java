package com.example.springdemo.dto;

import com.example.springdemo.entities.helper.Gender;
import com.example.springdemo.entities.helper.Role;

import java.util.List;

public class CaregiverDTO extends UserDTO {

    private List<PatientDTO> patients;

    public CaregiverDTO(String username, String password, String name, Gender gender, String birthday, String address, List<PatientDTO> patients) {
        super(username, password, name, gender, birthday, address, Role.CAREGIVER);
        this.patients = patients;
    }

    public List<PatientDTO> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientDTO> patients) {
        this.patients = patients;
    }
}
