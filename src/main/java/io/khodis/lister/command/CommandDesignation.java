package io.khodis.lister.command;

public enum CommandDesignation {
    START("start"),
    HELLO("hello"),
    CANCEL("cancel");

    private final String designation;

    CommandDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
