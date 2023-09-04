package org.theoliverlear.comment;


import java.util.ArrayList;
import java.util.StringTokenizer;

public class TextBlock {

    public static String createTextBlock(String text, int indent) {
        text = text.replace("\n", "");
        StringTokenizer tokens = new StringTokenizer(text);
        ArrayList<String> words = new ArrayList<>();
        while (tokens.hasMoreTokens()) {
            words.add(tokens.nextToken());
        }
        String commentChar = "// ";
        int commentCharCount = commentChar.length();
        int lineLimit = 78 - commentCharCount - indent;
        ArrayList<String> withNewLines = new ArrayList<>();
        int lineLength = 0;
        for (int i = 0; i < words.size(); i++) {
            if (lineLength == 0) {
                withNewLines.add(commentChar);
                lineLength += commentCharCount;
            }
            if (lineLength + words.get(i).length() > lineLimit) {
                withNewLines.add("\n" + commentChar);
                lineLength = 0;
            }
            withNewLines.add(words.get(i));
            lineLength += words.get(i).length();
            if (i != words.size() - 1) {
                withNewLines.add(" ");
                lineLength++;
            }
        }
        String newText = "";
        for (String word : withNewLines) {
            newText += word;
        }
        return newText;
    }

    public static void main(String[] args) {
        String text = "This is a long piece of text that will be split into" +
                " multiple lines. This is a long piece of text that will " +
                "be split into multiple lines. This is a long piece of " +
                "text that will be split into multiple lines.";
        System.out.println(createTextBlock(text, 4));
        String instructionsText = "Instructions:\n" +
                "\n" +
                "1.Design the Spoot class with Constructors, Getters, and Setters:\n" +
                "\n" +
                "   - Create a class called Spoot with the following attributes: name, color, weight and age.\n" +
                "   - Define constructors to initialize the Spoot objects with relevant attributes.\n" +
                "   - Implement appropriate getter and setter methods to access and modify Spoot attributes.\n" +
                "   - Create a method called \"details\" that will return the name, color, weight and age like so:\n" +
                "\"My name is Spooty. I am 4 years old. I am a blue Spoot and I weigh 2 lbs.\"\n" +
                "\n" +
                "3. Test Program:\n" +
                "   - Create a main class called Main to simulate interactions with the Spoot objects.\n" +
                "   - Instantiate 3 different Spoot and use the description method on each of them.\n" +
                "\n" +
                "4. Documentation:\n" +
                "   - Include comments in your code to explain the purpose and functionality of classes, methods, and significant blocks of code.\n" +
                "   - Write a header comment at the beginning of each file, including your name and a brief description of the assignment.";
        System.out.println(createTextBlock(instructionsText, 4));

    }
}
