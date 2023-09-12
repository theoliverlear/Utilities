package org.theoliverlear.comment.model;

import java.util.Scanner;

public class CommentGenerator {
    Heading heading;
    Clipboard clipboard;
    public CommentGenerator() {
        String headingStyle;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Enter a heading style:
                1. //----Heading----
                2. //===-Heading-===
                3. <!----Heading---->
                """);
        int styleChoice = scanner.nextInt();
        String artifact;
        switch (styleChoice) {
            case 1, 2 -> artifact = "//";
            case 3 -> artifact = "<!---->";
        }
    }

    public static void main(String[] args) {

    }
}
