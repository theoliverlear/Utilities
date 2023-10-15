package org.theoliverlear.comment.model;

public class Heading {
    private String style; // Ex. - Heading - =-Heading-= <!--Heading-->
    private String text;
    private String artifact;
    private boolean isIndentCorrected;
    private Editor editor;
    String comment;
    public Heading(String style, String text, String artifact, Editor editor,
                   boolean isIndentCorrected) {
        this.style = style;
        this.text = text;
        this.artifact = artifact;
        this.isIndentCorrected = isIndentCorrected;
        this.editor = editor;
        this.comment = "";
    }
    //------------------------------Methods-----------------------------------
    public void buildComment() {
        String headingBuilder = this.text;

    }
    //------------------------------Getters-----------------------------------
    public String getStyle() {
        return this.style;
    }
    public String getText() {
        return this.text;
    }
    public String getArtifact() {
        return this.artifact;
    }
    public boolean getIsIndentCorrected() {
        return this.isIndentCorrected;
    }
    public Editor getEditor() {
        return this.editor;
    }
    public String getComment() {
        return this.comment;
    }
    //------------------------------Setters-----------------------------------
    public void setStyle(String style) {
        this.style = style;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }
    public void setIsIndentCorrected(boolean isIndentCorrected) {
        this.isIndentCorrected = isIndentCorrected;
    }
    public void setEditor(Editor editor) {
        this.editor = editor;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
