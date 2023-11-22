package com.example.retrogamejock.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {


//    @GeneratedValue
//    @Column(name = "user_id")
//    Long userID;

    @Id
    @Column(nullable = false, unique = true)
    private String userName;
    private String password;
    private String email;
    private String profilePrivate = "true";

    @OneToMany(
            targetEntity = Role.class,
            cascade = CascadeType.ALL,
            mappedBy = "userName",
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Game> games;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GameSystem> gameSystems;



    // Getters and setters
//    public Long getUserID() {
//        return userID;
//    }
//
//    public void setUserID(Long userID) {
//        this.userID = userID;
//    }

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

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<GameSystem> getGameSystems() {
        return gameSystems;
    }

    public void setGameSystems(List<GameSystem> gameSystems) {
        this.gameSystems = gameSystems;
    }

    // Method to add a role
    public void addRole(Role role) {
        this.roles.add(role);
    }

    // Method to remove a role
    public void removeRole(Role role) {
        this.roles.remove(role);
    }
}