package app;
import java.util.ArrayList;
import java.util.Scanner;

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
