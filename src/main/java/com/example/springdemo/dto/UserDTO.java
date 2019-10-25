package com.example.springdemo.dto;

import com.example.springdemo.entities.helper.Gender;
import com.example.springdemo.entities.helper.Role;

public class UserDTO {

    private String username;
    private String password;
    private String name;
    private Gender gender;
    private String birthday;
    private String address;
    private Role role;

    public UserDTO(String username, String password, String name, Gender gender, String birthday, String address, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.role = role;
    }

    public UserDTO() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender Gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
