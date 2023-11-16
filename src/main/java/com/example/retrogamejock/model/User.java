package com.example.retrogamejock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long userID;
    private String userName;
    private String password;
    private String email;
    private boolean profileIsPrivate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Game> games;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GameSystem> gameSystems;

    // Default constructor
    public User() {
    }

    // Constructor
    public User(
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

    public boolean isProfileIsPrivate() {
        return profileIsPrivate;
    }

    public void setProfileIsPrivate(boolean profileIsPrivate) {
        this.profileIsPrivate = profileIsPrivate;
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
}
