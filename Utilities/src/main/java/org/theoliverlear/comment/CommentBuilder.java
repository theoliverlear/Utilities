package org.theoliverlear.comment;

import org.theoliverlear.comment.model.Editor;
import org.theoliverlear.comment.model.Heading;
import org.theoliverlear.comment.model.UserClipboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentBuilder {
    String comment;
    Heading heading;
    File config;
    //----------------------------Constructors--------------------------------
    public CommentBuilder() {

    }
    public CommentBuilder(String configPath) {
        this.heading = new Heading();
        this.config = new File(configPath);
        this.loadConfig();
    }
    public void buildComment() {
        Scanner scanner = new Scanner(System.in);
        String exit = "";
        do {
//            System.out.println("""
//                    1. //-----Heading-----
//                    2. //====-Heading-====
//                    3. <!-----Heading------>
//                    4. #------Heading-----""");
//            System.out.println("Enter the heading style: ");
//            int headingStyleChoice = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println("Enter the heading text: ");
//            String headingText = scanner.nextLine();
//            System.out.println("How long is an indent in spaces?");
//            int indentSize = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println("Enter the amount of indent levels: ");
//            int indentLevel = scanner.nextInt();
//            scanner.nextLine();
//            this.editor = new Editor(indentLevel, indentSize, 78);
//            String artifact = "//";
//            boolean isIndentCorrected = false;
//            this.heading = new Heading("Thin", headingText, artifact, this.editor,
//                    isIndentCorrected);
            this.heading.setText(this.getUserInput("Please enter the heading title: "));
            this.heading.getEditor().setIndentLevel(Integer.parseInt(this.getUserInput("Please enter the level of indentation: ")));
            this.heading.buildComment();
            this.comment = this.heading.getComment();
            this.copyToClipboard();
            System.out.println("Type \"exit\" to exit or press enter to continue.");
            exit = scanner.nextLine().trim();
        } while (!exit.contains("exit"));
    }
    public String getUserInput(String prompt) {
        Scanner userInput = new Scanner(System.in);
        System.out.println(prompt);
        return userInput.nextLine().trim();
    }
//----------------------------------Methods-----------------------------------
    public void loadConfig() {
        String configContents = "";
        try (Scanner fileReader = new Scanner(this.config)) {
            while (fileReader.hasNext()) {
                configContents += fileReader.next();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println(configContents);
        if (!configContents.isEmpty()) {
            Pattern pattern = Pattern.compile("indentationSize..(.*),");
            Matcher matcher = pattern.matcher(configContents);
            while (matcher.find()) {
                this.heading.getEditor().setIndentSize(Integer.parseInt(matcher.group(1).trim()));
            }
            pattern = Pattern.compile("lineLength..(.*)\\}]");
            matcher = pattern.matcher(configContents);
            while (matcher.find()) {
                this.heading.getEditor().setLineLength(Integer.parseInt(matcher.group(1).trim()));
            }
            pattern = Pattern.compile("\"indentCorrection\":(true|false)");
            matcher = pattern.matcher(configContents);
            while (matcher.find()) {
                this.heading.setIsIndentCorrected(Boolean.parseBoolean(matcher.group(1).trim()));
            }
            System.out.println("Is indent corrected: " + this.heading.getIsIndentCorrected());
        } else {
            System.out.println("Config file is empty.");
        }
    }

    public void copyToClipboard() {
        UserClipboard userClipboard = new UserClipboard(this.comment);
        userClipboard.applyText();
    }
    public static void main(String[] args) {
//        CommentBuilder commentBuilder = new CommentBuilder();
//        commentBuilder.buildComment();
        String configPath = "src/main/resources/editor_config.json";
        CommentBuilder commentBuilder = new CommentBuilder(configPath);
        commentBuilder.buildComment();
    }
}
