package com.example.retrogamejock.dto;

import jakarta.validation.constraints.*;

public class GameConditionInputDto {
    @Pattern(regexp = "true|false", message = "Complete in box must be true or false")
    private String completeInBox;

    @Pattern(regexp = "true|false", message = "Has manual must be true or false")
    private String hasManual;

    @Pattern(regexp = "true|false", message = "Has case must be true or false")
    private String hasCase;

    // Default constructor
    public GameConditionInputDto() {
    }

    // Constructor with all fields
    public GameConditionInputDto(String completeInBox, String hasManual, String hasCase) {
        this.completeInBox = completeInBox;
        this.hasManual = hasManual;
        this.hasCase = hasCase;
    }

    // Getters and setters

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
