package com.example.retrogamejock.dto;

import jakarta.validation.constraints.*;

public class GameInputDto {

    @NotNull(message = "Game name cannot be null")
    private String gameName;
    @NotNull(message = "Game review cannot be null")
    private String gameReview;
    @NotNull(message = "Game rating cannot be null")
    private String gameRating;

    // Default constructor
    public GameInputDto() {
    }

    // Constructor with all fields
    public GameInputDto(String gameName, String gameReview, String gameRating) {
        this.gameName = gameName;
        this.gameReview = gameReview;
        this.gameRating = gameRating;
    }

    // Getters and setters

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
}
