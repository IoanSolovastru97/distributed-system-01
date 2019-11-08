package com.example.springdemo.services;

import com.example.springdemo.SpringDemoApplicationTests;
import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.entities.helper.Gender;
import com.example.springdemo.entities.helper.Role;
import com.example.springdemo.errorhandler.IncorrectParameterException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends SpringDemoApplicationTests {

    @Autowired UserService userService;


    @Test(expected = IncorrectParameterException.class)
    public void insertDTOBad() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("john.patterson.gmail");
        userService.insert(userDTO);
    }

    @Test
    public void insertDTOGood() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("John Patterson");
        userDTO.setUsername("john.patterson@gmail.com");
        userDTO.setAddress("George Baritiu nr. 22");
        userDTO.setPassword("asd");
        userDTO.setGender(Gender.MALE);
        userDTO.setBirthday("30/05/2019");
        userDTO.setRole(Role.DOCTOR);
        String id = userService.insert(userDTO);
    }
}
