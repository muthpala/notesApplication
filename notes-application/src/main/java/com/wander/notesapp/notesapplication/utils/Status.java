package com.wander.notesapp.notesapplication.utils;


/**
 * The Status Enum class
 *
 * @author Muthukumar PL
 * @version 1.0
 */
public enum Status {
    ACTIVE("ACTIVE"), PASSIVE("PASSIVE");
    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
