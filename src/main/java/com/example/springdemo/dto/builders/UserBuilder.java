package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.entities.User;

public class UserBuilder {

    public static UserDTO generateDTOFromEntity(User user) {
        return new UserDTO(
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getGender(),
                user.getBirthday(),
                user.getAddress(),
                user.getRole());
    }

    public static User generateEntityFromDTO(UserDTO userDTO) {
        return new User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getName(),
                userDTO.getGender(),
                userDTO.getBirthday(),
                userDTO.getAddress(),
                userDTO.getRole());
    }

    public static com.example.springdemo.soap.User generateDTOToSoap(UserDTO userDTO) {
        com.example.springdemo.soap.User user = new com.example.springdemo.soap.User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setAddress(userDTO.getAddress());
        user.setBirthday(userDTO.getBirthday());
        user.setGender(userDTO.getGender().toString());
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole().toString());
        return user;
    }
}
