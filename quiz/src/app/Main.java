package app;

import java.io.IOException;

public class Main {

    public static void main (String []args) throws IOException {
        Quiz myQuiz = new Quiz();

        myQuiz.getQuestions(1);
        myQuiz.answerAlternatives(1);
        myQuiz.getCorrectAnswer(2);

        PlayerManager myPM = new PlayerManager();
        myPM.startUp();

    }
}
