package org.theoliverlear.comment.gui;

import java.awt.*;

public class GUI {
    //----------------------------Constructors--------------------------------
    public GUI() {
        Frame frame = new Frame();
        frame.setSize(500, 500);
        frame.setVisible(true);
        TextArea textArea = new TextArea();
        textArea.setSize(200, 200);
        frame.add(textArea);

    }
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
