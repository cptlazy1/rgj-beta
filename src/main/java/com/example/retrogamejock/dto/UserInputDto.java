package com.example.retrogamejock.dto;

import jakarta.validation.constraints.*;

public class UserInputDto {
    // ID is not necessary because it is auto-generated
    @NotNull(message = "Username cannot be null")
    @Size(min = 2, max = 20, message = "Username must be between 2-20 characters")

    private String userName;
    @NotNull
    private String password;
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "Profile is private cannot be null")
    @Pattern(regexp = "true|false", message = "Profile is private must be true or false")
    private String profileIsPrivate;

    // Default constructor
    public UserInputDto() {
    }

    // Constructor with all fields
    public UserInputDto(
            String userName,
            String password,
            String email,
            String profileIsPrivate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.profileIsPrivate = profileIsPrivate;
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

    public String isProfileIsPrivate() {
        return profileIsPrivate;
    }

    public void setProfileIsPrivate(String profileIsPrivate) {
        this.profileIsPrivate = profileIsPrivate;
    }
}
