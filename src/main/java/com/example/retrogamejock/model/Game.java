package com.example.retrogamejock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameID;
    private String gameName;
    private String gameReview;
    private String gameRating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_condition_id")
    private GameCondition gameCondition;

    // Getters and setters
    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameReview() {
        return gameReview;
    }

    public void setGameReview(String gameReview) {
        this.gameReview = gameReview;
    }

    public String getGameRating() {
        return gameRating;
    }

    public void setGameRating(String gameRating) {
        this.gameRating = gameRating;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGameCondition(GameCondition gameCondition) {
        this.gameCondition = gameCondition;
    }
}
