package org.theoliverlear.comment;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class ThinHeadingCorrected {
    public static String thinHeadingCorrected(String heading, int indent) {
        heading = heading.trim();
        heading = "-" + heading + "-";
        heading = heading.replace(" ", "-");

        int headingLength = heading.length();
        int thinHeadingLength = 78;
        String commentPrefix = "//";
        thinHeadingLength -= commentPrefix.length();
        int titleAdjust = thinHeadingLength - headingLength;
        int left = titleAdjust / 2;
        int right = titleAdjust - left;
        left -= indent;

        String leftThinHeading = "-".repeat(left);
        String rightThinHeading = "-".repeat(right);
        return commentPrefix + leftThinHeading + heading + rightThinHeading;
    }
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        do {

            System.out.println("Enter a heading:");
            String heading = userInput.nextLine();
            System.out.println("Enter an indent:");
            int indent = userInput.nextInt();
            String headingCorrected = thinHeadingCorrected(heading, indent);
            System.out.println("Copied to clipboard: " + headingCorrected);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(headingCorrected);
            clipboard.setContents(stringSelection, null);
            userInput.nextLine();
        } while (true);
    }
}

