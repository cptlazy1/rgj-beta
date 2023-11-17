package com.example.retrogamejock.dto;

import jakarta.validation.constraints.*;

public class GameSystemConditionInputDto {

//    @NotNull(message = "hasBox cannot be null")
    @Pattern(regexp = "true|false", message = "hasBox must be true or false")
    private String hasBox;

//    @NotNull(message = "hasCables cannot be null")
    @Pattern(regexp = "true|false", message = "hasCables must be true or false")
    private String hasCables;

//    @NotNull(message = "isModified cannot be null")
    @Pattern(regexp = "true|false", message = "isModified must be true or false")
    private String isModified;

    // Default constructor
    public GameSystemConditionInputDto() {
    }

    // Constructor with all fields
    public GameSystemConditionInputDto(String hasBox, String hasCables, String isModified) {
        this.hasBox = hasBox;
        this.hasCables = hasCables;
        this.isModified = isModified;
    }

    // Getters and setters
    public String isHasBox() {
        return hasBox;
    }

    public void setHasBox(String hasBox) {
        this.hasBox = hasBox;
    }

    public String isHasCables() {
        return hasCables;
    }

    public void setHasCables(String hasCables) {
        this.hasCables = hasCables;
    }

    public String isModified() {
        return isModified;
    }

    public void setModified(String modified) {
        isModified = modified;
    }
}
