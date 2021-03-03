package app.serialization;

import java.util.ArrayList;

public class Printer {

    // skriver ut alla frågor
    public static void printAllQuestions (ArrayList<Question> questions) {

        for (Question question : questions) {
            System.out.println(question.getText());
        }
    }

    public static void printOptions(ArrayList<Option> options){

        for (Option option : options) {
            System.out.println(option.text);
        }
    }

    public static void main (String[] args) {

        printAllQuestions(FileHandler.readQuestions());
    }

    // Om jag behöver edit så ska jag ta in en index

}