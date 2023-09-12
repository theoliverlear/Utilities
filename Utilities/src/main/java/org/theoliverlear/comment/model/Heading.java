package org.theoliverlear.comment.model;

public class Heading {
    String style; // Ex. - Heading - =-Heading-= <!--Heading-->
    String text;
    String artifact;
    Editor editor;
    public Heading(String style, String text, Editor editor) {
        this.style = style;
        this.text = text;
        this.editor = editor;
    }
    public Heading(String style, String text, String artifact, Editor editor) {
        this.style = style;
        this.text = text;
        this.artifact = artifact;
        this.editor = editor;
    }
    //------------------------------Getters-----------------------------------
    public String getStyle() {
        return this.style;
    }
    public String getText() {
        return this.text;
    }
    public Editor getEditor() {
        return this.editor;
    }
}
