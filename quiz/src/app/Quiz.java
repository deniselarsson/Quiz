package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Quiz implements Serializable {
    // Klass Quiz
    //Ni ska skapa en klass som håller reda på frågor, svarsalternativ och vilket svarsalternativ som är rätt.

    String quiz_md = "C:\\Users\\cakeDiv\\Desktop\\Quiz-dev\\Quiz-dev\\quiz\\src\\Files\\Quiz.md";
    Stream<String> tempQuiz = Files.lines(Paths.get(quiz_md));

    public Quiz() throws IOException {
    }

    /* A method called answerAlternatives with a int variable named alternativeNumber inside its parameters */
    public void answerAlternatives(int alternativeNumber) {
        String y = byteToString(quiz_md);
        //        String y = byteToString(options_txt);
        String[] x = y.split(";");
        System.out.println(x[alternativeNumber - 1]);
    }

    /* A method called getFacitAnswer with a int variable named questionNumber inside its parameters */
    public void getFacitAnswer(int questionNumber) {
        String y = byteToString(quiz_md);
        //        String y = byteToString(answers_txt);
        String[] x = y.split("\\.");
        System.out.println("Det rätta svaret var: " + x[questionNumber - 1]);
    }

    /* A method called byteToString with a int variable named filePath inside its parameters */
    private static String byteToString(String filePath) {
        String content = "";

        /* A try catch loop */
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /* A method called getQuestion with a int variable named questionNumber inside its parameters */
    public void getQuestions(int questionNumber) {
        String y = byteToString(quiz_md);
        //        String y = byteToString(questions_txt);
        String[] x = y.split(";");
        System.out.println(x[questionNumber - 1]);
    }

    /* A method called startJavaQuiz to run the pre defined quiz */
    public void startJavaQuiz() {
        tempQuiz
                .filter(x -> x.contains("Java"))
                .forEach(System.out::println);
        tempQuiz.close();
    }

    /* A method called startCustomQuiz
     * - Obs, should hold a new option menu asking the user to create a new quiz or start a previously created custom quiz */
    public void startCustomQuiz() throws IOException, ClassNotFoundException {
        Scanner mySc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter option");
            System.out.println("[1] load custom quizzes");
            System.out.println("[2] create a new custom quiz");

            /* A character variable created named aInput for reading the option the user make */
            char aInput = mySc.next().charAt(0);

            /* A switch case that, depending on which option the user make, run different methods */
            switch (aInput) {
                /* Case 1 forward the user to the method playerOption in class PlayerManager through our created object named myPM */
                case '1' -> {
                    tempQuiz
                            .filter(x -> x.contains("Custom"))
                            .forEach(System.out::println);
                    tempQuiz.close();

                }
                /* Case 2 forward the user to the method infoOption in class GameManager through our created object named myGM */
                case '2' -> createCustomQuiz();
                /* Case 0 enable the user to exit the program safely */
                case '0' -> System.exit(0);
                /* This command enable the user to try again if aInput doesnt match any of the alternatives above */
                default -> System.out.println("Invalid input, try again!");
            }

        }
    }

    private Object createCustomQuiz() throws IOException, ClassNotFoundException {
        ObjectInputStream myIn = new ObjectInputStream(new FileInputStream(quiz_md));
        Object aResult = myIn.readObject();
        myIn.close();
        return aResult;
    }
}

