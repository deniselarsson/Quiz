package app;

import java.util.Scanner;

public class TestMain {

    public static void main (String[] args) {

        test1();

    }
    public static void test1 (){

        QuestionManager questionManager = new QuestionManager();
        questionManager.load();
        QuizManager quizManager = new QuizManager(questionManager.questions);

        for (int i = 0; i < 6; i++) {
            Question question = quizManager.getNextQuestion();
            QuestionManager.printQuestion(question);
            QuestionManager.printOptions(question.getOptions());
            System.out.println("\nPlease enter you anwear:");

            Scanner scan = new Scanner(System.in);
            int userAnswer = Integer.parseInt(scan.nextLine()) - 1;

            if (QuizManager.isCorrectAnswer(question, userAnswer)) {
                System.out.println("CORRECT ANSWER!");
            }
            else {
                System.out.println("WRONG ANSWER");
            }


        }
    }
}
