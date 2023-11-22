package com.example.retrogamejock.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(RoleKey.class)
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @Column(nullable = false)
    private String userName;
//    private String roleName;


    @Id
    @Column(nullable = false)
    private String role;

    // Default constructor
    public Role() {
    }


    // Constructor with all fields
    public Role(
            String userName,
            String role) {
        this.userName = userName;
        this.role = role;
    }

    // Getters and setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
