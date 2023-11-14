package com.example.retrogamejock.dto;

public class GameSystemConditionInputDto {

    private boolean hasBox;
    private boolean hasCables;
    private boolean isModified;

    // Default constructor
    public GameSystemConditionInputDto() {
    }

    // Constructor with all fields
    public GameSystemConditionInputDto(boolean hasBox, boolean hasCables, boolean isModified) {
        this.hasBox = hasBox;
        this.hasCables = hasCables;
        this.isModified = isModified;
    }

    // Getters and setters
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
