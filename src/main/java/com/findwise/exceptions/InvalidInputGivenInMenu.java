package com.findwise.exceptions;

public class InvalidInputGivenInMenu extends NumberFormatException {
    public InvalidInputGivenInMenu() {
        super("You can only choose between 1-3");
    }

    public InvalidInputGivenInMenu(String msg) {
        super(msg);
    }
}
