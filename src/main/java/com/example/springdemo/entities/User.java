package com.example.springdemo.entities;

import com.example.springdemo.entities.helper.Gender;
import com.example.springdemo.entities.helper.Profile;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "profile")
    @Enumerated(EnumType.STRING)
    private Profile profile;

    /*
    @OneToMany(mappedBy= "")
    List<Item> items;
     */

    public User(String username, String password, String name, Gender gender, String birthday, String address, Profile profile) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.profile = profile;
    }

    public User(String username, String password, Profile profile) {

    }

    public User() {
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

    public void setGender(Gender gender) {
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
