package com.wander.notesapp.notesapplication.utils;


/**
 * The Roles Enum class
 *
 * @author Muthukumar PL
 * @version 1.0
 */
public enum Roles {
    ROLE_ADMIN(1), ROLE_USER(2);
    private int value;

    Roles(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
