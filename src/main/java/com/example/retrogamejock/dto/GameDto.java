package com.example.retrogamejock.dto;

public class GameDto {
    private Long gameID;
    private String gameName;
    private String gameReview;
    private char gameRating;

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
