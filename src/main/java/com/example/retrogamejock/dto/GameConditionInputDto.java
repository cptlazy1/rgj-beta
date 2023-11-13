package com.example.retrogamejock.dto;

public class GameConditionInputDto {

    // TODO: Add validation
    private boolean isCompleteInBox;
    private boolean hasManual;
    private boolean hasCase;

    // Default constructor
    public GameConditionInputDto() {
    }

    // Constructor
    public GameConditionInputDto(boolean isCompleteInBox, boolean hasManual, boolean hasCase) {
        this.isCompleteInBox = isCompleteInBox;
        this.hasManual = hasManual;
        this.hasCase = hasCase;
    }

    // Getters and setters
    public boolean isCompleteInBox() {return isCompleteInBox;}

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
