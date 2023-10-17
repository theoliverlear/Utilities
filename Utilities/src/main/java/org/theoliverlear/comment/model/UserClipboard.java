package org.theoliverlear.comment.model;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class UserClipboard {
    Clipboard AWTClipboard;
    String text;
    //----------------------------Constructors--------------------------------
    public UserClipboard(String text) {
        this.AWTClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        this.text = text;
    }
    public void applyText() {
        StringSelection stringSelection = new StringSelection(this.text);
        this.AWTClipboard.setContents(stringSelection, null);
        System.out.println("Copied to clipboard: " + this.text);
    }
    //------------------------------Getters-----------------------------------
    public Clipboard getAWTClipboard() {
        return this.AWTClipboard;
    }
    public String getText() {
        return this.text;
    }
}
