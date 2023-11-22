package com.example.retrogamejock.dto;

public class UserDto {
//    private Long userID;
    private String userName;
//    private String password; // password shouldn't be in the output dto
    private String email;
//    private String profilePrivate; // This is also not necessary in the output dto



    // Getters and setters
//    public Long getUserID() {
//        return userID;
//    }

//    public void setUserID(Long userID) {
//        this.userID = userID;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public String getPassword() {
//        return password;
//    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getProfilePrivate() {
//        return profilePrivate;
//    }

//    public void setProfilePrivate(String profilePrivate) {
//        this.profilePrivate = profilePrivate;
//    }
}
