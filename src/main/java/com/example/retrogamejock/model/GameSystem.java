package com.example.retrogamejock.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "game_systems")
public class GameSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_system_id")
    Long gameSystemID;
    private String gameSystemName;
    private String gameSystemReview;
    private String gameSystemRating;

    @OneToOne
    private GameSystemCondition gameSystemCondition;

    @ManyToOne
    @JoinColumn(name = "user_name")
    private User user;

    // Getters and setters
    public Long getGameSystemID() {
        return gameSystemID;
    }

    public void setGameSystemID(Long gameSystemID) {
        this.gameSystemID = gameSystemID;
    }

    public String getGameSystemName() {
        return gameSystemName;
    }

    public void setGameSystemName(String gameSystemName) {
        this.gameSystemName = gameSystemName;
    }

    public String getGameSystemReview() {
        return gameSystemReview;
    }

    public void setGameSystemReview(String gameSystemReview) {
        this.gameSystemReview = gameSystemReview;
    }

    public String getGameSystemRating() {
        return gameSystemRating;
    }

    public void setGameSystemRating(String gameSystemRating) {
        this.gameSystemRating = gameSystemRating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGameSystemCondition(GameSystemCondition gameSystemCondition) {
        this.gameSystemCondition = gameSystemCondition;
    }
}
