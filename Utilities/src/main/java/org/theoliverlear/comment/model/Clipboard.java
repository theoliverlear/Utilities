package org.theoliverlear.comment.model;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class Clipboard {
    java.awt.datatransfer.Clipboard AWTClipboard;
    String text;
    public Clipboard(String text) {
        this.AWTClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        this.text = text;
        this.applyText();
    }
    public void applyText() {
        StringSelection stringSelection = new StringSelection(this.text);
        this.AWTClipboard.setContents(stringSelection, null);
    }
    //------------------------------Getters-----------------------------------
    public java.awt.datatransfer.Clipboard getAWTClipboard() {
        return this.AWTClipboard;
    }
    public String getText() {
        return this.text;
    }
}
