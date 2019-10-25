package com.example.springdemo.controller;

import com.example.springdemo.dto.DrugDTO;
import com.example.springdemo.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/healthcare/drug")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @GetMapping(value = "/{username}")
    public DrugDTO findById(@PathVariable("username") Integer username) {
        return drugService.findById(username);
    }

    @GetMapping
    public List<DrugDTO> findAll() {
        return drugService.findAll();
    }

    @PostMapping()
    public Integer insert(@RequestBody DrugDTO drugDTO) {
        return drugService.insert(drugDTO);
    }


    @DeleteMapping()
    public void delete(@RequestBody DrugDTO drugDTO) {
        drugService.delete(drugDTO);
    }
}
