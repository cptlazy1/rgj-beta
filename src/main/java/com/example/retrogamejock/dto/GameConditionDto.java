package com.example.retrogamejock.dto;

public class GameConditionDto {

    private Long gameConditionID;
    private String completeInBox;
    private String hasManual;
    private String hasCase;

    // Default constructor
    public GameConditionDto() {
    }

    // Constructor
    public GameConditionDto(Long gameConditionID, String completeInBox, String hasManual, String hasCase) {
        this.gameConditionID = gameConditionID;
        this.completeInBox = completeInBox;
        this.hasManual = hasManual;
        this.hasCase = hasCase;
    }

    // Getters and setters

    public Long getGameConditionID() {
        return gameConditionID;
    }

    public void setGameConditionID(Long gameConditionID) {
        this.gameConditionID = gameConditionID;
    }

    public String getCompleteInBox() {
        return completeInBox;
    }

    public void setCompleteInBox(String completeInBox) {
        this.completeInBox = completeInBox;
    }

    public String getHasManual() {
        return hasManual;
    }

    public void setHasManual(String hasManual) {
        this.hasManual = hasManual;
    }

    public String getHasCase() {
        return hasCase;
    }

    public void setHasCase(String hasCase) {
        this.hasCase = hasCase;
    }
}
