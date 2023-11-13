package com.example.retrogamejock.dto;

public class GameConditionInputDto {

    // TODO: Add validation
    private boolean isCompleteInBox;
    private boolean hasManual;
    private boolean hasCase;

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
