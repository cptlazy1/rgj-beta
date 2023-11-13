package com.example.retrogamejock.dto;

public class GameConditionDto {

    private Long gameConditionID;
    private boolean isCompleteInBox;
    private boolean hasManual;
    private boolean hasCase;

    // Default constructor
    public GameConditionDto() {
    }

    // Constructor
    public GameConditionDto(Long gameConditionID, boolean isCompleteInBox, boolean hasManual, boolean hasCase) {
        this.gameConditionID = gameConditionID;
        this.isCompleteInBox = isCompleteInBox;
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

    public boolean isCompleteInBox() {
        return isCompleteInBox;
    }

    public void setCompleteInBox(boolean completeInBox) {
        isCompleteInBox = completeInBox;
    }

    public boolean isHasManual() {
        return hasManual;
    }

    public void setHasManual(boolean hasManual) {
        this.hasManual = hasManual;
    }

    public boolean isHasCase() {
        return hasCase;
    }

    public void setHasCase(boolean hasCase) {
        this.hasCase = hasCase;
    }
}
