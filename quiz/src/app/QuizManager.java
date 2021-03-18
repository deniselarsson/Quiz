package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class QuizManager {
    private ArrayList<Question> questions;

    public QuizManager(ArrayList<Question> questions) {
        this.questions = new ArrayList<>(questions);
    }

    public Question getNextQuestion(){
         Random random = new Random();
         Integer index = random.nextInt(questions.size() -1);
         Question question = questions.get(index);
         this.questions.remove(question);
         return question;
    }

    public static boolean isCorrectAnswer(Question question, Integer index) {
        return question.getOptions().get(index).getIsCorrectAnswer();
    }
}
