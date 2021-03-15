package app;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
//För att frågorna ska kunna serializeras till en fil måste objektet implementera Serializable interface
public class QuizManager implements Serializable {

    private String text;
    public ArrayList<Option> options = new ArrayList<>();

    public void setText (String text) {
        this.text = text;
    }

    public String getText () {
        return text;
    }

    public String toString () {
        return getText();
    }

    //Läser frågan från användaren
    public static String readQuestionText () {

        Scanner scan = new Scanner(System.in);
        System.out.println("Write your question:");
        return scan.nextLine();
    }

    //sätter texten som kommer från användaren
    public static QuizManager createQuestion () {

        QuizManager question = new QuizManager();
        question.setText(readQuestionText());
        return question;
    }

    //Skriver in den nya frågan + options + om det är rätt eller fel svar till questions filen
    public static void setNewQuestion () {

        ArrayList<QuizManager> questions = readQuestions();
        QuizManager question = createQuestion();
        questions.add(question);
        writeQuestions(questions);
        question.options.addAll(Option.createOptions());
        readQuestions();
    }

    //Skriver ut alla frågor som finns i questions filen
    public static void printAllQuestions (ArrayList<QuizManager> questions) {

        for (QuizManager question : questions) {
            System.out.println(question.getText());
        }
    }
    //Skriver ut en fråga utifrån vilken index jag anropa
    public static void printOneQuestion (ArrayList<QuizManager> questions) {
        System.out.println(questions.get(1));
    }

    //Läser in frågor från user till filen questions.txt
    public static ArrayList<QuizManager> readQuestions () {

        try {
            return (ArrayList<QuizManager>) FileHandler.read("questions.txt");
        }
        catch (IOException e) {
            return new ArrayList<>();
        }
        catch (ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    //Skriver frågorna till filen questions.txt
    public static void writeQuestions (ArrayList<QuizManager> question) {
        FileHandler.write("questions.txt", question);
    }

}

// handle questions
// List questions
// add questions
// -> ask for q
// --> ask for x number of answers, max 5
// ---> loop add new answer method x times, max 5
// ---> ask if which of x inputs is the correct answer, obs. only one correct or more? ---> let player choose by entering one (or more) of the numbers 1-5
// -----> save question, alternatives and correct answer is correct
// remove questions
// edit questions