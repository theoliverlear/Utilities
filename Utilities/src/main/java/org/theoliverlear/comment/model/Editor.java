package org.theoliverlear.comment.model;

public class Editor {
    private int indentLevel;
    private int indentSize;
    public Editor(int indentLevel, int indentSize) {
        this.indentLevel = indentLevel;
        this.indentSize = indentSize;
    }
    //------------------------------Getters-----------------------------------
    public int getIndentLevel() {
        return this.indentLevel;
    }
    public int getIndentSize() {
        return this.indentSize;
    }
    //------------------------------Setters-----------------------------------
    public void setIndentLevel(int indentLevel) {
        this.indentLevel = indentLevel;
    }
    public void setIndentSize(int indentSize) {
        this.indentSize = indentSize;
    }
}
