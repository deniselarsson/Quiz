package app;

import app.serialization.FileHandler;
import app.serialization.Question;

import java.io.IOException;
import java.util.ArrayList;
import static app.serialization.Helper.*;

public class Main {

    public static void main (String []args) throws IOException {
        Quiz myQuiz = new Quiz();

        myQuiz.getQuestions(1);
        myQuiz.answerAlternatives(1);
        myQuiz.getCorrectAnswer(2);

        PlayerManager myPM = new PlayerManager();
        myPM.startUp();

        //En lista skapas till filen = om det inte finns en fil skapas det en ny text fil i metoden readQuestions()
        ArrayList<Question> questions = FileHandler.readQuestions();

        //sätter en text = och skapa en ny fråga
        Question question = createQuestion();
        //lägger till input texten till arraylist question
        questions.add(question);
        //skriver in till filen
        FileHandler.writeQuestions(questions);

        question.options.addAll(creatOptions());
        FileHandler.readQuestions();

    }
}