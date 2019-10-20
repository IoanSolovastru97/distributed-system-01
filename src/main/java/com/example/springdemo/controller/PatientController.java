package com.example.springdemo.controller;

import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/{username}")
    public PatientDTO findById(@PathVariable("username") String username) {
        return patientService.findById(username);
    }

    @GetMapping(value = "/{username}/medicalrecord")
    public List<MedicalRecordDTO> getMedicalRecords(@PathVariable("username") String username) {
        return patientService.getMedicalRecords(username);
    }
}
