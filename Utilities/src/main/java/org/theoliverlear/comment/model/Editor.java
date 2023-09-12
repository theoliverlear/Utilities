package org.theoliverlear.comment.model;

public class Editor {
    private int indentLevel;
    private int indentSize;
    public Editor(int indentLevel, int indentSize) {
        this.indentLevel = indentLevel;
        this.indentSize = indentSize;
    }
    public int getIndentLevel() {
        return this.indentLevel;
    }
    //------------------------------Getters-----------------------------------
    public int getIndentSize() {
        return this.indentSize;
    }
}
