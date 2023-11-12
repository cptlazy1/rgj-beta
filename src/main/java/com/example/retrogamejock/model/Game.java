package com.example.retrogamejock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameID;
    private String gameName;
    private String gameReview;
    private char gameRating;

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

    public char getGameRating() {
        return gameRating;
    }

    public void setGameRating(char gameRating) {
        this.gameRating = gameRating;
    }
}
