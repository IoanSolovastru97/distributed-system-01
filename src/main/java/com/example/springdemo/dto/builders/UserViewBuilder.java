package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.UserViewDTO;
import com.example.springdemo.entities.User;

public class UserViewBuilder {
    public static UserViewDTO generateDTOFromEntity(User user) {
        return new UserViewDTO(
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }

    public static User generateEntityFromDTO(UserViewDTO userViewDTO) {
        return new User(
                userViewDTO.getUsername(),
                userViewDTO.getPassword(),
                userViewDTO.getRole());
    }
}
