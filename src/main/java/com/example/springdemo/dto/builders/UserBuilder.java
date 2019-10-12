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
                user.getProfile());
    }

    public static User generateEntityFromDTO(UserDTO userDTO) {
        return new User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getName(),
                userDTO.getGender(),
                userDTO.getBirthday(),
                userDTO.getAddress(),
                userDTO.getProfile());
    }
}
