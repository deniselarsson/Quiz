package app.serialization;

import java.util.ArrayList;

public class Printer {


    public static void printAllQuestions (ArrayList<Question> questions) {

        for (Question question : questions) {
            System.out.println(question.getText());
        }
    }
}