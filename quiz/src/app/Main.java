package app;

import app.serialization.FileHandler;
import app.serialization.Question;

import java.io.IOException;
import java.util.ArrayList;
import static app.serialization.Helper.*;

public class Main {

    public static void main (String []args) throws IOException {

        /********************StartUP**********************************/

        PlayerManager myPM = new PlayerManager();
        myPM.startUp();

        /********************QUIZ**********************************/
        Quiz myQuiz = new Quiz();

        myQuiz.getQuestions(1);
        myQuiz.answerAlternatives(1);
        myQuiz.getCorrectAnswer(2);

        /********************SERIALIZATION**********************************/
      /*  ArrayList<Question> questions = FileHandler.readQuestions();


        Question question = createQuestion();
        questions.add(question);
        FileHandler.writeQuestions(questions);
        question.options.addAll(creatOptions());
       */
    }
}