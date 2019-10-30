package com.example.springdemo.services;

import com.example.springdemo.dto.*;
import com.example.springdemo.dto.builders.*;
import com.example.springdemo.entities.*;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.*;
import com.example.springdemo.validators.UserFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        patientDTO.setPassword(getPassword(patientDTO.getPassword()));

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

    public void deletePatient(String username) {
        this.patientRepository.deleteById(username);
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
        List<Caregiver> caregivers = caregiverRepository.findAll();

        return caregivers.stream()
                .map(CaregiverBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public String insertCaregiver(CaregiverDTO caregiverDTO) {

        UserFieldValidator.validateInsertOrUpdate(caregiverDTO);
        caregiverDTO.setPassword(getPassword(caregiverDTO.getPassword()));
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

    public void deleteCaregiver(String username) {
        this.caregiverRepository.deleteById(username);
    }

    //Drug CRUD
    public DrugDTO findDrugById(Integer id) {
        Optional<Drug> user = drugRepository.findById(id);

        if (!user.isPresent()) {
            throw new ResourceNotFoundException("Drug", "drug id", id);
        }
        return DrugBuilder.generateDTOFromEntityWithId(user.get());
    }

    public List<DrugDTO> findAllDrugs() {
        List<Drug> drugs = drugRepository.findAll();

        return drugs.stream()
                .map(DrugBuilder::generateDTOFromEntityWithId)
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
    public Integer insertMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        return medicalRecordRepository
                .save(MedicalRecordBuilder.generateEntityFromDTO(medicalRecordDTO))
                .getId();
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

    public List<MedicalRecordDTO> getAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findAll();

        return medicalRecords.stream()
                .map(MedicalRecordBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    //Helper
    private String getPassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    //Doctor CRUD
    public DoctorDTO findById(String id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);

        if (!doctor.isPresent()) {
            throw new ResourceNotFoundException("Doctor", "doctor id", id);
        }
        return DoctorBuilder.generateDTOFromEntity(doctor.get());
    }

    public List<DoctorDTO> findAll() {
        List<Doctor> doctors = doctorRepository.findAll();

        return doctors.stream()
                .map(DoctorBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public String insert(DoctorDTO doctorDTO) {
        doctorDTO.setPassword(getPassword(doctorDTO.getPassword()));
        return doctorRepository
                .save(DoctorBuilder.generateEntityFromDTO(doctorDTO))
                .getUsername();
    }

    public String update(DoctorDTO doctorDTO) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorDTO.getUsername());

        if (!doctor.isPresent()) {
            throw new ResourceNotFoundException("Doctor", "doctor id", doctorDTO.getUsername());
        }
        return doctorRepository.save(DoctorBuilder.generateEntityFromDTO(doctorDTO)).getUsername();
    }

    public void delete(DoctorDTO doctorDTO) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorDTO.getUsername());

        if (!doctor.isPresent()) {
            throw new ResourceNotFoundException("Doctor", "doctor id", doctorDTO.getUsername());
        }
        doctorRepository.deleteById(DoctorBuilder.generateEntityFromDTO(doctorDTO).getUsername());
    }


}
