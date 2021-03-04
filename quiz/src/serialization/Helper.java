package serialization;

import java.util.ArrayList;
import java.util.Scanner;

public class Helper {

    public Helper(){}
    public static String readQuestionText () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your question:");
        return scan.nextLine();
    }

    public static Question createQuestion () {
        Question question = new Question();
        question.setText(readQuestionText());
        return question;
    }

    public static ArrayList<Option> createOptions () {
        ArrayList<Option> options = new ArrayList<>();

        for (int i = 0; i < 1; i++) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Write your option: ");
            String text = scan.nextLine();

            System.out.println("Is this the correct answer(Y/N)");
            String y = scan.nextLine();

            Option option = new Option(text, y.equals("y"));
            createOptions().add(new Option(options));
        }
        return options;
    }
}