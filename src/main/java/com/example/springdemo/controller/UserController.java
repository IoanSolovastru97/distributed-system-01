package com.example.springdemo.controller;


import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/healthcare/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{username}")
    public UserDTO findById(@PathVariable("username") String username){
        return userService.findUserById(username);
    }

    @GetMapping()
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @PostMapping()
    public String insertUserDTO(@RequestBody UserDTO userDTO){
        return userService.insert(userDTO);
    }

    @PutMapping()
    public String updateUser(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @DeleteMapping()
    public void delete(@RequestBody UserDTO userDTO){
        userService.delete(userDTO);
    }
}
