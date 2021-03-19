package app;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionManager {

    private final String fileName = "questions.txt";

    ArrayList<Question> questions;

    public void load () {
        try {
            questions = (ArrayList<Question>) FileHandler.read(fileName);
        }
        catch (Exception e) {
            questions = new ArrayList<>();
        }
    }

    public void save () {
        FileHandler.write(fileName, questions);
    }

    public void addQuestion () {
        Question question = new Question();
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your question:");
        question.setText(scan.nextLine());
        question.getOptions().addAll(readOptions());
        questions.add(question);
    }

    private ArrayList<Option> readOptions () {
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

    public void printAllQuestions () {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + " - " + questions.get(i).getText());
        }
    }

    public static void printQuestion (Question question) {
        System.out.println(question.getText());
    }

    public static void printOptions (ArrayList<Option> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + " - " + options.get(i).getText());
        }
    }
    public static void deleteQuestion () throws InterruptedException {

        QuestionManager questionManager = new QuestionManager();

        System.out.println("Which question do you want to delete?\n");
        Thread.sleep(1000);
        questionManager.load();
        questionManager.printAllQuestions();

        Scanner scan = new Scanner(System.in);
        System.out.print("\nDelete: ");
        Integer index = Integer.parseInt(scan.nextLine()) - 1;
        if (questionManager.questions.remove(questionManager.questions.get(index))) {
            System.out.println("Question removed");
            Thread.sleep(2000);
        }
        else {
            System.out.println("Could not remove question");
        }
        questionManager.save();
        questionManager.printAllQuestions();
    }
}
