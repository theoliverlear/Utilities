package org.theoliverlear.color;

public enum Color {
    RESET("\u001B[0m"),
    RED("\u001B[31m");
    final String ANSI_COLOR;
    Color(String ANSI_COLOR) {
        this.ANSI_COLOR = ANSI_COLOR;
    }
    public String toString() {
        return this.ANSI_COLOR;
    }
    public String getANSIColor() {
        return this.ANSI_COLOR;
    }
}
