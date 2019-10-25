package com.example.springdemo.controller;

import com.example.springdemo.dto.IntakeIntervalDTO;
import com.example.springdemo.services.IntakeIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/healthcare/intake")
public class IntakeIntervalController {
    
    
    @Autowired
    private IntakeIntervalService intakeIntervalService;

    @GetMapping(value = "/{username}")
    public IntakeIntervalDTO findById(@PathVariable("username") Integer username) {
        return intakeIntervalService.findById(username);
    }

    @GetMapping
    public List<IntakeIntervalDTO> findAll() {
        return intakeIntervalService.findAll();
    }

    @PostMapping()
    public Integer insert(@RequestBody IntakeIntervalDTO intakeIntervalDTO) {
        return intakeIntervalService.insert(intakeIntervalDTO);
    }


    @DeleteMapping()
    public void delete(@RequestBody IntakeIntervalDTO intakeIntervalDTO) {
        intakeIntervalService.delete(intakeIntervalDTO);
    }
}
