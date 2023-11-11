package com.example.retrogamejock.dto;

public class GameSystemInputDto {

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
