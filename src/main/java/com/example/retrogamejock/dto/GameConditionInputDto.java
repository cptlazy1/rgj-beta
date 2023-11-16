package com.example.retrogamejock.dto;

import jakarta.validation.constraints.*;

public class GameConditionInputDto {

    @NotNull(message = "Complete in box cannot be null")
    @Pattern(regexp = "true|false", message = "Complete in box must be true or false")
    private String isCompleteInBox;
    @NotNull(message = "Has manual cannot be null")
    @Pattern(regexp = "true|false", message = "Has manual must be true or false")
    private String hasManual;
    @NotNull(message = "Has case cannot be null")
    @Pattern(regexp = "true|false", message = "Has case must be true or false")
    private String hasCase;

    // Default constructor
    public GameConditionInputDto() {
    }

    // Constructor with all fields
    public GameConditionInputDto(String isCompleteInBox, String hasManual, String hasCase) {
        this.isCompleteInBox = isCompleteInBox;
        this.hasManual = hasManual;
        this.hasCase = hasCase;
    }

    // Getters and setters
    public String isCompleteInBox() {return isCompleteInBox;}

    public void setCompleteInBox(String completeInBox) {
        isCompleteInBox = completeInBox;
    }

    public String isHasManual() {
        return hasManual;
    }

    public void setHasManual(String hasManual) {
        this.hasManual = hasManual;
    }

    public String isHasCase() {
        return hasCase;
    }

    public void setHasCase(String hasCase) {
        this.hasCase = hasCase;
    }
}
