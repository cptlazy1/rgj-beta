package com.example.retrogamejock.dto;

// This class is used for PostMapping and PutMapping

import jakarta.validation.constraints.*;

public class GameSystemInputDto {


    private String gameSystemName;

    private String gameSystemReview;

    private String gameSystemRating;

    // Default constructor
    public GameSystemInputDto() {
    }

    // Constructor with all fields
    public GameSystemInputDto(String gameSystemName, String gameSystemReview, String gameSystemRating) {
        this.gameSystemName = gameSystemName;
        this.gameSystemReview = gameSystemReview;
        this.gameSystemRating = gameSystemRating;
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
