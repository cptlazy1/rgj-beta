package com.example.retrogamejock.dto;

public class UserDto {
    private Long userID;
    private String userName;
    private String password;
    private String email;
    private boolean profileIsPrivate;

    // Default constructor
    public UserDto() {
    }

    // Constructor
    public UserDto(
            Long userID,
            String userName,
            String password,
            String email,
            boolean profileIsPrivate) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.profileIsPrivate = profileIsPrivate;
    }

    public Long getUserID() {return userID;}

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

    public boolean isProfileIsPrivate() {
        return profileIsPrivate;
    }

    public void setProfileIsPrivate(boolean profileIsPrivate) {
        this.profileIsPrivate = profileIsPrivate;
    }
}
