package com.example.retrogamejock.dto;
import jakarta.validation.constraints.*;

// This class is used for PostMapping and PutMapping
// User is given as body in Postman
// Validation is done in this class
public class UserInputDto {
//    @NotNull(message = "Username cannot be empty")
    private String userName;
//    @NotNull(message = "Password cannot be empty")
    private String password;
//    @Email(message = "Email should be valid")
    private String email;
//    @NotNull(message = "ProfileIsPrivate cannot be empty")
    private boolean profileIsPrivate;

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

    public boolean isProfileIsPrivate() {
        return profileIsPrivate;
    }

    public void setProfileIsPrivate(boolean profileIsPrivate) {
        this.profileIsPrivate = profileIsPrivate;
    }
}
