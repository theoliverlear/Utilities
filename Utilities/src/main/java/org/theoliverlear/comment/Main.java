package org.theoliverlear.comment;

/*
    This project can be many things. One thing in particular is
    when I go to make comment header, I spend much of the time
    trying to balance the length of the comment header to meet
    an even number of characters on both sides and always ceases
    at 79 characters. I intend to make a tool, algorithm, generator,
    or whatever you want to call it to make comment headers for me
    in the style I like and with the balance I like. I will also see
    if I can expand on this idea to other things like moving and
    cutting off text to the next line if they exceed 79
    characters.
 */
//----------------------------------Getters-----------------------------------
    //------------------------------Getters-----------------------------------

// Could I turn this idea into an executable jar file
// and turn it into an app for intellij?
// Maybe Link this in style guide

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;
//----------------------------Getters-and-Setters-----------------------------
// maybe put this in theoliverlear utilities
public class Main {

    public static String thinHeading(String heading) {
        heading = heading.trim();
        heading = "-" + heading + "-";
        heading = heading.replace(" ", "-");
        int headingLength = heading.length();
        int thinHeadingLength = 78;
        thinHeadingLength -= 2;
        int titleAdjust = thinHeadingLength - headingLength;
        int left = titleAdjust / 2;
        int right = titleAdjust - left;
        String commentPrefix = "//";
        String leftThinHeading = "-".repeat(left);
        String rightThinHeading = "-".repeat(right);
        return commentPrefix + leftThinHeading + heading + rightThinHeading;
    }
    public static String thinHeading(String heading, int indent) {
        heading = heading.trim();
        heading = "-" + heading + "-";
        heading = heading.replace(" ", "-");
        int headingLength = heading.length();
        int thinHeadingLength = 78;
        thinHeadingLength -= 2;
        thinHeadingLength -= indent;
        int titleAdjust = thinHeadingLength - headingLength;
        int left = titleAdjust / 2;
        int right = titleAdjust - left;
        String commentPrefix = "//";
        String leftThinHeading = "-".repeat(left);
        String rightThinHeading = "-".repeat(right);
        return commentPrefix + leftThinHeading + heading + rightThinHeading;
    }

    public static String thinHeadingCorrected(String heading, int indent) {
        heading = heading.trim();
        heading = "-" + heading + "-";
        heading = heading.replace(" ", "-");
        int headingLength = heading.length();
        int thinHeadingLength = 78;
        thinHeadingLength -= 2;
        int titleAdjust = thinHeadingLength - headingLength;
        int left = titleAdjust / 2;
        int right = titleAdjust - left;
        left -= indent;
        String commentPrefix = "//";
        String leftThinHeading = "-".repeat(left);
        String rightThinHeading = "-".repeat(right);
        return commentPrefix + leftThinHeading + heading + rightThinHeading;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // maybe turn this into a gui
        boolean continueProgram = true;
        do {
            System.out.println("Please enter your current indent level: ");
            int indent = userInput.nextInt();
            String heading = "";
            String thinHeading = "";
            if (indent > 0) {
                userInput.nextLine();
                System.out.println("Would you like to account for " +
                                   "indentation in the heading name? (y/n)");
                String indentCorrectResponse = userInput.nextLine();
                if (indentCorrectResponse.equals("y")) {
                    System.out.println("Enter heading:");
                    heading = userInput.nextLine();
                    thinHeading = thinHeadingCorrected(heading, indent);
                } else {
                    System.out.println("Enter heading:");
                    heading = userInput.nextLine();
                    thinHeading = thinHeading(heading, indent);
                }
            } else {
                userInput.nextLine();
                System.out.println("Enter heading:");
                heading = userInput.nextLine();
                thinHeading = thinHeading(heading);
            }
            System.out.println("Copied to clipboard: " + thinHeading);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(thinHeading);
            clipboard.setContents(stringSelection, null);
            System.out.println("Continue? (y/n)");
            String continueProgramString = userInput.nextLine();
            if (continueProgramString.equals("n")) {
                continueProgram = false;
            }
        } while (continueProgram);
    }
}