package org.theoliverlear.comment.gui;

import org.theoliverlear.comment.model.Editor;
import org.theoliverlear.comment.model.Heading;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends Frame {
    TextField headingText;
    TextArea commentText;

    //----------------------------Constructors--------------------------------
    public GUI() {
        setSize(300, 300);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.commentText = new TextArea();
        this.commentText.setBounds(100, 300, 100, 100);
        this.headingText = new TextField();
        this.headingText.setBounds(100, 100, 100, 100);
        this.headingText.setSize(100, 100);
        add(headingText);
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        this.headingText.setMaximumSize(new Dimension(100, 100));
        repaint();
    }
    public void paint(Graphics g) {
        g.drawString("Hello World", 100, 100);
//        Editor editor = new Editor(1, 4, 78);
//        Heading heading = new Heading("Thin", headingText.getText(), "//", editor, false);
//        heading.buildThinComment();
//        g.drawString(heading.getComment(), 100, 300);
//        this.commentText.setText(heading.getComment());
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
