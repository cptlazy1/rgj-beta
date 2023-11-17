package com.example.retrogamejock.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class GameInputDto {


    @NotNull(message = "Game name cannot be null")
    @Size(max = 50, message = "Game name must be less than 50 characters")
    private String gameName;

    @Size(max = 200, message = "Game review must be less than 200 characters")
    private String gameReview;

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
