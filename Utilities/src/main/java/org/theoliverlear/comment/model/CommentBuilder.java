package org.theoliverlear.comment.model;
//=================================-Imports-==================================
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentBuilder {
    //============================-Variables-=================================
    String comment;
    Heading heading;
    File config;
    //===========================-Constructors-===============================
    public CommentBuilder(String configPath) {
        this.heading = new Heading();
        this.config = new File(configPath);
        this.loadConfig();
    }
    //=============================-Methods-==================================

    //---------------------------Build-Comment--------------------------------
    public void buildComment() {
        Scanner scanner = new Scanner(System.in);
        String exit = "";
        do {
            int commentTypeChoice = 0;
            do {
                try {
                    String commentTypePrompt = """
                            1. //--------Heading--------
                            2. //=======-Heading-=======
                            3. <!--------Heading------->
                            4. #---------Heading--------
                            5. #========-Heading-=======""";
                    commentTypeChoice = Integer.parseInt(getUserInput(commentTypePrompt));
                    if (commentTypeChoice < 1 || commentTypeChoice > 5) {
                        System.out.println("Please enter a valid number.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException | NumberFormatException ex) {
                    String validNumberMessage = "Please enter a valid number.";
                    System.err.println(validNumberMessage);
                }
            } while (true);
            switch (commentTypeChoice) {
                case 1 -> this.heading.setHeadingType(HeadingType.THIN);
                case 2 -> this.heading.setHeadingType(HeadingType.THICK);
                case 3 -> this.heading.setHeadingType(HeadingType.HTML);
                case 4 -> this.heading.setHeadingType(HeadingType.THIN_HASH);
                default -> this.heading.setHeadingType(HeadingType.THIN);
            }
            String headingPrompt = "Please enter the heading title: ";
            this.heading.setText(getUserInput(headingPrompt));
            int indentLevel = 0;
            do {
                try {
                    String indentationPrompt = "Please enter the level of indentation: ";
                    indentLevel = Integer.parseInt(getUserInput(indentationPrompt));
                    break;
                } catch (InputMismatchException | NumberFormatException ex) {
                    String validNumberMessage = "Please enter a valid number.";
                    System.err.println(validNumberMessage);
                }
            } while (true);

            this.heading.getEditor().setIndentLevel(indentLevel);
            this.heading.buildComment();
            this.comment = this.heading.getComment();
            this.copyToClipboard();
            String exitPrompt = "Type \"exit\" to exit or press enter to continue.";
            System.out.println(exitPrompt);
            exit = scanner.nextLine().trim();
        } while (!exit.contains("exit"));
    }
    //--------------------------Get-User-Input--------------------------------
    public static String getUserInput(String prompt) {
        Scanner userInput = new Scanner(System.in);
        System.out.println(prompt);
        return userInput.nextLine().trim();
    }
    //----------------------------Load-Config---------------------------------
    public void loadConfig() {
        String configContents = "";
        try (Scanner fileReader = new Scanner(this.config)) {
            while (fileReader.hasNext()) {
                configContents += fileReader.next();
            }
        } catch (FileNotFoundException ex) {
            // Stop the program if the config file is not found.
            throw new RuntimeException("Config file not found.");
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
    //-------------------------Copy-To-Clipboard------------------------------
    public void copyToClipboard() {
        UserClipboard userClipboard = new UserClipboard(this.comment);
        userClipboard.applyText();
    }
    //===============================-Main-===================================
    public static void main(String[] args) {
        String configPath = "src/main/resources/editor_config.json";
        CommentBuilder commentBuilder = new CommentBuilder(configPath);
        commentBuilder.buildComment();
    }
}
