package org.theoliverlear.comment;

import org.theoliverlear.comment.model.Editor;
import org.theoliverlear.comment.model.Heading;

import java.util.Scanner;

public class CommentBuilder {
    String comment;
    Heading heading;
    public CommentBuilder() {

    }
    public void buildComment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1. //-----Heading-----
                2. //====-Heading-====
                3. //<!---Heading---->
                4. #------Heading-----""");
        System.out.println("Enter the heading style: ");
        int headingStyleChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the heading text: ");
        String headingText = scanner.nextLine();
        System.out.println("How long is an indent in spaces?");
        int indentSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the amount of indent levels: ");
        int indentLevel = scanner.nextInt();
        scanner.nextLine();
        Editor editor = new Editor(indentLevel, indentSize);
    }

    public static void main(String[] args) {
        CommentBuilder commentBuilder = new CommentBuilder();
        commentBuilder.buildComment();
    }
}
