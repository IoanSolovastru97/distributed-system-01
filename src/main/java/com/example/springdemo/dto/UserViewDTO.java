package com.example.springdemo.dto;

import com.example.springdemo.entities.helper.Profile;

public class UserViewDTO {
    private String username;
    private String password;
    private Profile profile;

    public UserViewDTO(String username, String password, Profile profile) {
        this.password = password;
        this.username = username;
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
