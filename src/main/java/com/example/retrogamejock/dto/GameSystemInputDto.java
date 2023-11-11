package com.example.retrogamejock.dto;

// This class is used for PostMapping and PutMapping
// User is given as body in Postman
public class GameSystemInputDto {

    // TO DO: Add validation
    private String gameSystemName;
    private String gameSystemReview;
    private char gameSystemRating;

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

    public char getGameSystemRating() {
        return gameSystemRating;
    }

    public void setGameSystemRating(char gameSystemRating) {
        this.gameSystemRating = gameSystemRating;
    }
}
