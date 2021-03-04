package app;

import serialization.FileHandler;
import serialization.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static serialization.Helper.createOptions;
import static serialization.Helper.createQuestion;

public class QuizManager {

    /* A method named quizOption */
    public void quizOption() throws IOException {
        /* Objects created from
        a. library class SCANNER named mySc */
        Scanner mySc = new Scanner(System.in);

        /* While loop introducing menu layout explaining the available options for the user */
        while (true) {
            System.out.println("        Choose Quiz       \n");
            System.out.println(" [1] Java");
            System.out.println(" [2] Custom");
            System.out.println(" [0] Return");
            System.out.println(" - - - - - - - - - - - - - - - ");

            /* A character variable created named aInput for reading the option the user make */
            char aInput = mySc.next().charAt(0);

            /* A switch case that, depending on which option the user make, run different methods */
            switch (aInput) {
                /* Case 1 forward the user to the method displayJavaQuiz */
                case '1' -> displayJavaQuiz();
                /* Case 2 forward the user to the method displayCustomQuiz */
                case '2' -> displayCustomQuiz();
                /* Case 0 enable the user to return to the previous menu in the program safely w/o the need to restart the quiz */
                case '0' -> {
                    return;
                }
                /* This command enable the user to try again if aInput doesnt match any of the alternatives above */
                default -> System.out.println("Invalid input, try again!");
            }
        }
    }

    /* A method named displayJavaQuiz creating an object of the class Quiz then forwarding the user to the method startJavaQuiz inside the Quiz class */
    public void displayJavaQuiz() throws IOException {
        Quiz myJavaQuiz = new Quiz();
        myJavaQuiz.startJavaQuiz();
    }
    /* A method called displayCustomQuiz forwarding the user to the serialization inside the serialization package */
    public void displayCustomQuiz() throws IOException {
//        String playerQuiz_md = "...\\file\\Quiz.md";
//        Stream<String> tempPlayerQuiz = Files.lines(Paths.get(playerQuiz_md));
//        tempPlayerQuiz
//                .filter(x -> x.contains("Custom"))
//                .forEach(System.out::println);
//        tempPlayerQuiz.close();

        /********************SERIALIZATION**********************************/
        ArrayList<Question> questions = FileHandler.readQuestions();
        Question question = createQuestion();
        questions.add(question);
        FileHandler.writeQuestions(questions);
        question.options.addAll(createOptions());
        FileHandler.readQuestions();
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