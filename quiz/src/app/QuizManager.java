package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

//För att frågorna ska kunna serializeras till en fil måste
// objektet implementera Serializable interface
public class QuizManager implements Serializable {

    // The file where we store the questions
    private final String fileName = "questions.txt";

    // The list of questions loaded from the file
    ArrayList<Question> questions;

    // Loads the questions from the file
    // If there is no file or it cant be read a empty question list is created
    public void load() {
        try {
            questions = (ArrayList<Question>) FileHandler.read(fileName);
        }
        catch (Exception e) {
            questions = new ArrayList<>();
        }
    }

    // Saves the question list to file
    public void save() {
        FileHandler.write(fileName, questions);
    }

    // Adds a question to the list
    // NOTE: You need to call save to persist it to file
    public void addQuestion() {
        Question question = new Question();
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your question:");
        question.setText(scan.nextLine());
        question.getOptions().addAll(readOptions());
        questions.add(question);
    }

    // Reads the question options
    // NOTE: Currently hardcoded to 3
    private ArrayList<Option> readOptions() {
        ArrayList<Option> options = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Write your option: ");
            String text = scan.nextLine();
            System.out.println("Is this the correct answer(Y/N)");
            String y = scan.nextLine();
            Option option = new Option(text, y.equals("y"));
            options.add(option);

        }
        return options;
    }

    // Writes all questions in the question list
    public void printAllQuestions () {

        for (Question question : questions) {
            System.out.println(question.getText());
        }
    }

   // Prints the question
    public static void printQuestion (Question question) {
        System.out.println(question.getText());
    }

    // Prints the questions options
    public static void printOptions (ArrayList<Option> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + " - " + options.get(i).getText());
        }
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