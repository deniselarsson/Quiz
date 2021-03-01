package App.suggestion.q;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class QuizManager {
    public void quizOption() throws IOException {
        Scanner myScan = new Scanner(System.in);
        while (true) {
            System.out.println("        Choose Quiz       \n");
            System.out.println(" [1] Java");
            System.out.println(" [2] Custom");
            System.out.println(" [0] Return");
            System.out.println(" - - - - - - - - - - - - - - - ");
            char aInput = myScan.next().charAt(0);

            switch (aInput) {
                case '1' -> displayJavaQuiz();
                case '2' -> displayCustomQuiz();
                case '0' -> {
                    return;
                }
                default -> System.out.println("Invalid input, try again!");
            }
        }
    }

    public void displayJavaQuiz() throws IOException {
        Quiz myJavaQuiz = new Quiz();
        myJavaQuiz.startJavaQuiz();
    }

    public void displayCustomQuiz() throws IOException {
        String playerQuiz_md = "...\\file\\Quiz.md";
        Stream<String> tempPlayerQuiz = Files.lines(Paths.get(playerQuiz_md));
        tempPlayerQuiz
                .filter(x -> x.contains("Custom"))
                .forEach(System.out::println);
        tempPlayerQuiz.close();
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
