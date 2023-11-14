package com.example.retrogamejock.dto;

public class GameSystemConditionDto {

    private Long gameSystemConditionID;
    private boolean hasBox;
    private boolean hasCables;
    private boolean isModified;

    // Default constructor
    public GameSystemConditionDto() {
    }

    // Constructor with all fields
    public GameSystemConditionDto(Long gameSystemConditionID, boolean hasBox, boolean hasCables, boolean isModified) {
        this.gameSystemConditionID = gameSystemConditionID;
        this.hasBox = hasBox;
        this.hasCables = hasCables;
        this.isModified = isModified;
    }

    // Getters and setters

    public Long getGameSystemConditionID() {
        return gameSystemConditionID;
    }

    public void setGameSystemConditionID(Long gameSystemConditionID) {
        this.gameSystemConditionID = gameSystemConditionID;
    }

    public boolean isHasBox() {
        return hasBox;
    }

    public void setHasBox(boolean hasBox) {
        this.hasBox = hasBox;
    }

    public boolean isHasCables() {
        return hasCables;
    }

    public void setHasCables(boolean hasCables) {
        this.hasCables = hasCables;
    }

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }
}
