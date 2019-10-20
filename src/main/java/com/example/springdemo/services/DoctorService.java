package com.example.springdemo.services;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.DrugDTO;
import com.example.springdemo.dto.MedicalRecordDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.builders.CaregiverBuilder;
import com.example.springdemo.dto.builders.DrugBuilder;
import com.example.springdemo.dto.builders.MedicalRecordBuilder;
import com.example.springdemo.dto.builders.PatientBuilder;
import com.example.springdemo.entities.*;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.*;
import com.example.springdemo.validators.UserFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private CaregiverRepository caregiverRepository;
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    @Autowired
    private DrugRepository drugRepository;

    //Patients CRUD
    public PatientDTO findPatientById(String id) {
        Optional<Patient> patient = patientRepository.findById(id);

        if (!patient.isPresent()) {
            throw new ResourceNotFoundException("Patient", "patient id", id);
        }
        return PatientBuilder.generateDTOFromEntity(patient.get());
    }

    public List<PatientDTO> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public String insertPatient(PatientDTO patientDTO) {

        UserFieldValidator.validateInsertOrUpdate(patientDTO);

        return patientRepository
                .save(PatientBuilder.generateEntityFromDTO(patientDTO))
                .getUsername();
    }

    public String updatePatient(PatientDTO patientDTO) {

        Optional<Patient> patient = patientRepository.findById(patientDTO.getUsername());

        if (!patient.isPresent()) {
            throw new ResourceNotFoundException("Patient", "patient id", patientDTO.getUsername());
        }
        UserFieldValidator.validateInsertOrUpdate(patientDTO);

        return patientRepository.save(PatientBuilder.generateEntityFromDTO(patientDTO)).getUsername();
    }

    public void deletePatient(PatientDTO patientDTO) {
        this.patientRepository.deleteById(patientDTO.getUsername());
    }

    ///Caregiver CRUD
    public CaregiverDTO findCaregiverById(String id) {
        Optional<Caregiver> caregiver = caregiverRepository.findById(id);

        if (!caregiver.isPresent()) {
            throw new ResourceNotFoundException("Caregiver", "caregiver id", id);
        }
        return CaregiverBuilder.generateDTOFromEntity(caregiver.get());
    }

    public List<CaregiverDTO> findAllCaregivers() {
        List<Caregiver> caregivers = caregiverRepository.getAllOrdered();

        return caregivers.stream()
                .map(CaregiverBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public String insertCaregiver(CaregiverDTO caregiverDTO) {

        UserFieldValidator.validateInsertOrUpdate(caregiverDTO);

        return caregiverRepository
                .save(CaregiverBuilder.generateEntityFromDTO(caregiverDTO))
                .getUsername();
    }

    public String updateCaregiver(CaregiverDTO caregiverDTO) {

        Optional<Caregiver> caregiver = caregiverRepository.findById(caregiverDTO.getUsername());

        if (!caregiver.isPresent()) {
            throw new ResourceNotFoundException("Caregiver", "caregiver id", caregiverDTO.getUsername());
        }
        UserFieldValidator.validateInsertOrUpdate(caregiverDTO);

        return caregiverRepository.save(CaregiverBuilder.generateEntityFromDTO(caregiverDTO)).getUsername();
    }

    public void deleteCaregiver(CaregiverDTO caregiverViewDTO) {
        this.caregiverRepository.deleteById(caregiverViewDTO.getUsername());
    }

    //Drug CRUD
    public DrugDTO findDrugById(Integer id) {
        Optional<Drug> user = drugRepository.findById(id);

        if (!user.isPresent()) {
            throw new ResourceNotFoundException("Drug", "drug id", id);
        }
        return DrugBuilder.generateDTOFromEntity(user.get());
    }

    public List<DrugDTO> findAllDrugs() {
        List<Drug> drugs = drugRepository.findAll();

        return drugs.stream()
                .map(DrugBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Integer insertDrug(DrugDTO drugDTO) {
        return drugRepository
                .save(DrugBuilder.generateEntityFromDTO(drugDTO))
                .getId();
    }

    public Integer updateDrug(DrugDTO drugDTO) {
        Optional<Drug> user = drugRepository.findById(drugDTO.getId());

        if (!user.isPresent()) {
            throw new ResourceNotFoundException("User", "user id", drugDTO.getId());
        }

        return drugRepository.save(DrugBuilder.generateEntityFromDTO(drugDTO)).getId();
    }

    public void deleteDrug(DrugDTO userViewDTO) {
        this.drugRepository.deleteById(userViewDTO.getId());
    }

    //Medical Record
    public MedicalRecordDTO createMedicalRecord(String doctorID, String patientID, List<Drug> drugs, List<IntakeInterval> intakeIntervals, String period) {
        Optional<Patient> patient = patientRepository.findById(patientID);
        if (!patient.isPresent()) {
            throw new ResourceNotFoundException("Patient", "patient id", patientID);
        }
        Optional<Doctor> doctor = doctorRepository.findById(doctorID);

        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO(patient.get(), doctor.get(), period, drugs, intakeIntervals);
        medicalRecordRepository.save(MedicalRecordBuilder.generateEntityFromDTO(medicalRecordDTO));
        return medicalRecordDTO;
    }

    public List<MedicalRecordDTO> getMedicalRecords(String doctorId) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if (!doctor.isPresent()) {
            throw new ResourceNotFoundException("Doctor", "doctor id", doctorId);
        }

        return doctor.get().
                getMedicalRecords().
                stream().
                map(MedicalRecordBuilder::generateDTOFromEntity).
                collect(Collectors.toList());
    }

}
