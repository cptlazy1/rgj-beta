package com.example.retrogamejock.dto;

public class GameConditionDto {

    private Long gameConditionID;
    private boolean isCompleteInBox;
    private boolean hasManual;
    private boolean hasCase;


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
