package com.example.retrogamejock.dto;

// This class is used for PostMapping and PutMapping

public class GameSystemInputDto {

    // TODO: Add validation
    private String gameSystemName;
    private String gameSystemReview;
    private String gameSystemRating;

    // Default constructor
    public GameSystemInputDto() {
    }

    // Getters and setters
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
}
