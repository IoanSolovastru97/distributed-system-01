package com.example.springdemo.controller;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.builders.PatientBuilder;
import com.example.springdemo.services.CaregiverService;
import com.example.springdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/caregiver")
public class CaregiverController {

    @Autowired
    private CaregiverService caregiverService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{username}")
    public CaregiverDTO findById(@PathVariable("username") String username) {
        return caregiverService.findCaregiverById(username);
    }

    @GetMapping
    public List<CaregiverDTO> findAll() {
        return caregiverService.findAll();
    }

    @PostMapping
    public String insertCaregiver(@RequestBody CaregiverDTO caregiverDTO) {
        return caregiverService.insert(caregiverDTO);
    }

    @PutMapping()
    public String updateCaregiver(@RequestBody CaregiverDTO caregiverDTO) {
        return caregiverService.update(caregiverDTO);
    }

    @DeleteMapping()
    public void delete(@RequestBody CaregiverDTO caregiverDTO) {
        caregiverService.delete(caregiverDTO);
    }

    @GetMapping(value = "/{username}/getPatient")
    public List<PatientDTO> getPatients(@PathVariable("username") String username) {
       return caregiverService.findAllPatients(username);
    }

    //User
//    @GetMapping(value = "/{username}/details")
//    public UserViewDTO getCaregiverDetails(String id) {
//        return userService.findUserById(id);
//    }

}
