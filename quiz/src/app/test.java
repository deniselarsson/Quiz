package app;

import java.util.Scanner;

public class test {

    public static void main (String[] args) {

        //QuizManager quizManager = new QuizManager();
        //quizManager.load();

        //quizManager.addQuestion();

        //quizManager.save();

        // quizManager.printAllQuestions();
        //startTheQuiz();
        runQuestionQuiz();

    }
    public static void startTheQuiz () {

        QuizManager quizManager = new QuizManager();

        quizManager.load();

        Question currentQuestion = quizManager.questions.get(0);
        QuizManager.printQuestion(currentQuestion);
        QuizManager.printOptions(currentQuestion.getOptions());

        System.out.println("\nPlease enter you anwear:");

        Scanner scan = new Scanner(System.in);
        int userAnswer = Integer.parseInt(scan.nextLine()) - 1;

        Option option = currentQuestion.getOptions().get(userAnswer);

        if (option.getIsCorrectAnswer()) {
            System.out.println("Answer is correct");
        }
        else {
            System.out.println("Answer is not correct");
        }
    }

    public static void runQuestionQuiz(){

        QuizManager questionBase = new QuizManager();

        int i = 0;

        while(i < 6){
            questionBase.load();
            Question currentQuestion = questionBase.questions.get(i);
            QuizManager.printQuestion(currentQuestion);
            QuizManager.printOptions(currentQuestion.getOptions());
            System.out.println("\nPlease enter you anwear:");
            Scanner scan = new Scanner(System.in);
            int userAnswer = Integer.parseInt(scan.nextLine()) - 1;
            Option option = currentQuestion.getOptions().get(userAnswer);

            if (option.getIsCorrectAnswer()) {
                System.out.println("CORRECT ANSWER!");

            }
            else {
                System.out.println("WRONG ANSWER");

            }
            i ++;
        }
    }
}
