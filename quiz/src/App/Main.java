package App;

import java.io.IOException;

public class Main {

    public static void main (String []args) throws IOException {

        Quiz myQuiz = new Quiz();
        myQuiz.getQuestions("1 ");
        myQuiz.answerAlternatives("1");
        myQuiz.getCorrectAnswer("1");

    }
}
