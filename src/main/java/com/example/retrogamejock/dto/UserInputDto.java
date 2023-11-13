package com.example.retrogamejock.dto;


// This class is used for PostMapping and PutMapping

public class UserInputDto {
    // ID is not necessary because it is auto-generated
    // TODO: Add validation
    private String userName;
    private String password;
    private String email;
    private boolean profileIsPrivate;

    // Default constructor
    public UserInputDto() {
    }

    // Constructor
    public UserInputDto(
            String userName,
            String password,
            String email,
            boolean profileIsPrivate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.profileIsPrivate = profileIsPrivate;
    }


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
