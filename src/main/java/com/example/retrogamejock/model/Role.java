package com.example.retrogamejock.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "role_id")
    private Long roleID;
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    // Default constructor
    public Role() {
    }


    // Constructor with all fields
    public Role(
            Long roleID,
            String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    // Getters and setters

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
