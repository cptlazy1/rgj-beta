package com.example.retrogamejock.dto;

import com.example.retrogamejock.model.Role;
import jakarta.validation.constraints.*;

import java.util.Set;

public class UserInputDto {

    // ID is not necessary because it is auto-generated

    @Size(min = 2, max = 20, message = "Username must be between 2-20 characters")
    private String userName;

    @Size(min = 8, max = 20, message = "Password must be between 8-20 characters")
    private String password;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "true|false", message = "Profile is private must be true or false")
    private String profilePrivate;

    private Set<Role> roles;

    // Default constructor
    public UserInputDto() {
    }

    // Constructor with all fields
    public UserInputDto(String userName, String password, String email, String profilePrivate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.profilePrivate = profilePrivate;
    }

    // Getters and setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePrivate() {
        return profilePrivate;
    }

    public void setProfilePrivate(String profilePrivate) {
        this.profilePrivate = profilePrivate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}