package com.example.retrogamejock.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false, length = 255)
    private String password;
    @Column
    private String email;
    @Column(nullable = false)
    private String profilePrivate = "true";
    @Column
    private String apikey;

    @OneToMany(
            targetEntity = Role.class,
            cascade = CascadeType.ALL,  // All means *ALL* operations are cascaded. Saving, updating, deleting, etc.
            mappedBy = "userName",      // This is why we don't need a repository for Role.
            orphanRemoval = true,       // If there is a role that is not associated with a user, it will be removed.
            fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Game> games;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GameSystem> gameSystems;

    // Method to add a role to a user
    public void addRole(Role role) {
        this.roles.add(role);
    }

    // Method to remove a role from a user
    public void removeRole(Role role) {
        this.roles.remove(role);
    }


    // Getters and setters
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

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}