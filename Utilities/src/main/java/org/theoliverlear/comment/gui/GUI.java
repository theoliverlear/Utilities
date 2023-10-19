package org.theoliverlear.comment.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {
    //----------------------------Constructors--------------------------------
    public GUI() {
        Frame frame = new Frame();
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        TextArea textArea = new TextArea();
        textArea.setSize(200, 200);
        textArea.setVisible(true);
        frame.add(textArea);
        // TODO: use check box to select heading style
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        Canvas canvas = new Canvas();
        canvas.setSize(200, 200);
        frame.add(canvas);
        canvas.setVisible(true);
        canvas.setBackground(Color.WHITE);
        Graphics graphics = canvas.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.drawString("Hello", 900, 900);
        canvas.paint(graphics);


    }
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
