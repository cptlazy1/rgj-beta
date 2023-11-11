package com.example.retrogamejock.dto;


// This class is used for PostMapping and PutMapping
// User is given as body in Postman
// Validation is done in this class - How to do it?
public class UserInputDto {
    // ID is not necessary because it is auto-generated
    private String userName;
    private String password;
    private String email;
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
