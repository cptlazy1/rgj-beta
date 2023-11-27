package com.example.retrogamejock.dto;

import com.example.retrogamejock.model.Role;

import java.util.Set;

public class UserDto {

    public String userName;
    public String password;
    public String email;
    public String profilePrivate;
    public Set<Role> roles;

    public String apikey;

   //  Getters and setters

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

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
