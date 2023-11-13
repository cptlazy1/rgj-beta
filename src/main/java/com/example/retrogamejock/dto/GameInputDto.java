package com.example.retrogamejock.dto;

public class GameInputDto {

    // TODO: Add validation
    private String gameName;
    private String gameReview;
    private String gameRating;

    // Constructor
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
