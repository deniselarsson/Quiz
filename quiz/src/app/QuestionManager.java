package app;
import java.util.ArrayList;
import java.util.Scanner;

import static app.Start.start;

/**
 @author  By: Denisé Larsson - Denna klassen hantera frågor
 */
public class QuestionManager {

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
        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + " - " + questions.get(i).getText());
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
    public static void deleteQuestion() throws InterruptedException {

        QuestionManager questionManager = new QuestionManager();

        System.out.println("Which question do you want to delete?\n" );
        Thread.sleep(1000);
        questionManager.load();
        questionManager.printAllQuestions();

        Scanner scan = new Scanner(System.in);
        System.out.print("\nDelete: ");
        Integer index = Integer.parseInt(scan.nextLine())- 1;
        if(questionManager.questions.remove(questionManager.questions.get(index))) {
            System.out.println("Question removed");
            Thread.sleep(5000);
        } else {
            System.out.println("Could not remove question");
        }
        questionManager.save();
        questionManager.printAllQuestions();
        start();
    }
}
