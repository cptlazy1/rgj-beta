package com.example.retrogamejock.dto;

public class UserDto {
    private Long userID;
    private String userName;
    private String password;
    private String email;
    private String profilePrivate;

    // Default constructor
    public UserDto() {
    }

    // Constructor
    public UserDto(
            Long userID,
            String userName,
            String password,
            String email,
            String profilePrivate) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.profilePrivate = profilePrivate;
    }

    // Getters and setters
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public String getProfilePrivate() {
        return profilePrivate;
    }

    public void setProfilePrivate(String profilePrivate) {
        this.profilePrivate = profilePrivate;
    }
}
