package com.example.retrogamejock.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game_system_conditions")
public class GameSystemCondition {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "game_system_condition_id")
    private Long gameSystemConditionID;
    private boolean hasBox;
    private boolean hasCables;
    private boolean isModified;

    @OneToOne(mappedBy = "gameSystemCondition")
    private GameSystem gameSystem;

    // Default constructor
    public GameSystemCondition() {
    }

    // Constructor with all fields
    public GameSystemCondition(Long gameSystemConditionID, boolean hasBox, boolean hasCables, boolean isModified) {
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

    public GameSystem getGameSystem() {
        return gameSystem;
    }

    public void setGameSystem(GameSystem gameSystem) {
        this.gameSystem = gameSystem;
    }
}
