package com.example.retrogamejock.dto;

public class GameSystemDto {
    public Long gameSystemID;
    public String gameSystemName;
    public String gameSystemReview;
    public String gameSystemRating;

    // Getters and setters

    public Long getGameSystemID() {
        return gameSystemID;
    }

    public void setGameSystemID(Long gameSystemID) {
        this.gameSystemID = gameSystemID;
    }

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
