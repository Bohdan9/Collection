package com.epam.deque.view;

public enum Command {
    ADD_FIRST_ELEMENT("Add 1 element"),
    ADD_LAST_ELEMENT("Add last"),
    DELETE_FIRST_ELEMENT("Delete first"),
    DELETE_LAST_ELEMENT("Delete last"),
    SHOW_SIZE("Show size"),
    SHOW_DEQUE("Show deque"),
    EXIT("Exit");

    private final String message;

    Command(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}


