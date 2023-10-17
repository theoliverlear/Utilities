package org.theoliverlear.comment.model;

public class Heading {
    private String style; // Ex. - Heading - =-Heading-= <!--Heading-->
    private String text;
    private String artifact;
    private boolean isIndentCorrected;
    private Editor editor;
    String comment;
    //----------------------------Constructors--------------------------------
    public Heading() {
        this.style = "";
        this.text = "Header Title";
        this.artifact = "//";
        this.editor = new Editor();
        this.comment = "";
        this.isIndentCorrected = false;
    }
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
        headingBuilder = headingBuilder.trim().replace(" ", "-");
        headingBuilder = "-" + headingBuilder + "-";
        int headingLength = headingBuilder.length();
        int lineLength = this.editor.getLineLength();
        lineLength -= this.artifact.length();
        int titleAdjust = lineLength - headingLength;
        int indentAdjust = this.editor.getIndentLevel() * this.editor.getIndentSize();
        titleAdjust -= indentAdjust;
        int left;
        int right;
        if (this.isIndentCorrected) {
            left = titleAdjust / 2;
            right = titleAdjust - left;
            left -= (indentAdjust / 2);
            right += (indentAdjust / 2);
        } else {
            left = titleAdjust / 2;
            right = titleAdjust - left;
        }
        String leftThinHeading = "-".repeat(left);
        String rightThinHeading = "-".repeat(right);
        this.comment = this.artifact + leftThinHeading + headingBuilder
                                     + rightThinHeading;
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
