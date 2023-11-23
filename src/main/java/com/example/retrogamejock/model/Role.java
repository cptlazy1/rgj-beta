package com.example.retrogamejock.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(RoleKey.class) // This way we can use two primary keys. One for userName and one for role. See RoleKey.java
@Table(name = "roles")
public class Role implements Serializable {

    @Id // Primary key nr.1
    @Column(nullable = false)
    private String userName;


    @Id // Primary key nr.2
    @Column(nullable = false)
    private String role;

    // Default constructor
    public Role() { }

    // Constructor with all fields
    public Role(String userName, String role) {
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
