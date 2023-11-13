package com.example.retrogamejock.dto;

public class GameDto {
    private Long gameID;
    private String gameName;
    private String gameReview;
    private String gameRating;

    // Default constructor
    public GameDto() {
    }

    // Constructor
    public GameDto(
            Long gameID,
            String gameName,
            String gameReview,
            String gameRating) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.gameReview = gameReview;
        this.gameRating = gameRating;
    }

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
}
