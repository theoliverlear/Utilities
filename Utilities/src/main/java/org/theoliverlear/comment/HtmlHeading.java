package org.theoliverlear.comment;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class HtmlHeading {
    public static String htmlHeading(String heading) {
        heading = heading.trim();
        heading = "-" + heading + "-";
        heading = heading.replace(" ", "-");
        int headingLength = heading.length();
        int thinHeadingLength = 78;
        String commentArtifacts = "<!---->";
        thinHeadingLength -= commentArtifacts.length();
        int titleAdjust = thinHeadingLength - headingLength;
        int left = titleAdjust / 2;
        int right = titleAdjust - left;
        String commentPrefix = "<!--";
        String commentSuffix = "-->";
        String leftThinHeading = "-".repeat(left);
        String rightThinHeading = "-".repeat(right);
        return commentPrefix + leftThinHeading + heading + rightThinHeading +
                commentSuffix;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        do {
            System.out.println("Enter a heading:");
            String heading = userInput.nextLine();
            String htmlHeading = htmlHeading(heading);
            System.out.println("Copied to clipboard: " + htmlHeading);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(htmlHeading);
            clipboard.setContents(stringSelection, null);
            System.out.println("Enter another heading? (y/n)");
            String answer = userInput.nextLine();
            if (!answer.equals("y")) {
                break;
            }
        } while (true);
    }
}
