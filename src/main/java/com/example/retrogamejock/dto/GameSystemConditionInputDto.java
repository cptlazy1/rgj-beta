package com.example.retrogamejock.dto;

import jakarta.validation.constraints.*;

public class GameSystemConditionInputDto {

//    @NotNull(message = "hasBox cannot be null")
    @Pattern(regexp = "true|false", message = "hasBox must be true or false")
    private String box;

//    @NotNull(message = "cables cannot be null")
    @Pattern(regexp = "true|false", message = "cables must be true or false")
    private String cables;

//    @NotNull(message = "modified cannot be null")
    @Pattern(regexp = "true|false", message = "modified must be true or false")
    private String modified;

    // Default constructor
    public GameSystemConditionInputDto() {
    }

    // Constructor with all fields
    public GameSystemConditionInputDto(String box, String cables, String modified) {
        this.box = box;
        this.cables = cables;
        this.modified = modified;
    }

    // Getters and setters

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getCables() {
        return cables;
    }

    public void setCables(String cables) {
        this.cables = cables;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}
