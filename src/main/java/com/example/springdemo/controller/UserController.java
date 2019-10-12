package com.example.springdemo.controller;


import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.dto.UserViewDTO;
import com.example.springdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{username}")
    public UserViewDTO findById(@PathVariable("username") String username){
        return userService.findUserById(username);
    }

    @GetMapping()
    public List<UserViewDTO> findAll(){
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
    public void delete(@RequestBody UserViewDTO userViewDTO){
        userService.delete(userViewDTO);
    }
}
