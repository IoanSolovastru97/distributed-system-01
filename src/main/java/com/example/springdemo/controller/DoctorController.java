package com.example.springdemo.controller;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.DrugDTO;
import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.entities.Drug;
import com.example.springdemo.entities.IntakeInterval;
import com.example.springdemo.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //Patient
    @GetMapping(value = "/patient/{username}")
    public PatientDTO findPatientById(@PathVariable("username") String username) {
        return doctorService.findPatientById(username);
    }

    @GetMapping(value = "/patient")
    public List<PatientDTO> findAllPatients() {
        return doctorService.findAllPatients();
    }

    @PostMapping(value = "/patient")
    public String insertPatient(@RequestBody PatientDTO patientDTO) {
        return doctorService.insertPatient(patientDTO);
    }

    @PutMapping(value = "/patient")
    public String updatePatient(@RequestBody PatientDTO patientDTO) {
        return doctorService.updatePatient(patientDTO);
    }

    @DeleteMapping(value = "/patient")
    public void deletePatient(@RequestBody PatientDTO patientDTO) {
        doctorService.deletePatient(patientDTO);
    }

    //Caregiver
    @GetMapping(value = "/caregiver/{username}")
    public CaregiverDTO findCaregiverById(@PathVariable("username") String username) {
        return doctorService.findCaregiverById(username);
    }

    @GetMapping(value = "/caregiver")
    public List<CaregiverDTO> findAllCaregivers() {
        return doctorService.findAllCaregivers();
    }

    @PostMapping(value = "/caregiver")
    public String insertCaregiver(@RequestBody CaregiverDTO caregiverDTO) {
        return doctorService.insertCaregiver(caregiverDTO);
    }

    @PutMapping(value = "/caregiver")
    public String updateCaregiver(@RequestBody CaregiverDTO caregiverDTO) {
        return doctorService.updateCaregiver(caregiverDTO);
    }

    @DeleteMapping(value = "/caregiver")
    public void deleteCaregiver(@RequestBody CaregiverDTO patientDTO) {
        doctorService.deleteCaregiver(patientDTO);
    }

    //Drugs
    @GetMapping(value = "/drug/{id}")
    public DrugDTO findDrugById(@PathVariable("id") Integer id) {
        return doctorService.findDrugById(id);
    }

    @GetMapping(value = "/drug")
    public List<DrugDTO> findAllDrugs() {
        return doctorService.findAllDrugs();
    }

    @PostMapping(value = "/drug")
    public Integer insertDrug(@RequestBody DrugDTO drugDTO) {
        return doctorService.insertDrug(drugDTO);
    }

    @PutMapping(value = "/drug")
    public Integer updateDrug(@RequestBody DrugDTO drugDTO) {
        return doctorService.updateDrug(drugDTO);
    }

    @DeleteMapping(value = "/drug")
    public void deleteDrug(@RequestBody DrugDTO patientDTO) {
        doctorService.deleteDrug(patientDTO);
    }

    //Medical Record
    @GetMapping(value = "/medicalrecord")
    public List<MedicalRecordDTO> getMedicalRecords(String username) {
        return doctorService.getMedicalRecords(username);
    }

    @PutMapping(value = "/medicalrecord")
    public MedicalRecordDTO createMedicalRecord(String doctorID, String patientID, List<Drug> drugs, List<IntakeInterval> intakeIntervals, String period) {
        return doctorService.createMedicalRecord(doctorID, patientID, drugs, intakeIntervals, period);
    }
}
