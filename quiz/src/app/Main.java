package app;
import java.util.Scanner;

import static app.Quiz.runQuestionQuiz;

public class Main {
    public static void main (String []args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();
        QuestionManager questionManager = new QuestionManager();

        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("---------WELCOME---------");
        System.out.println("[1] PLAY");
        System.out.println("[2] QUIZ OPTIONS");
        System.out.println("[3] EXIT");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                player1 = Player.createPlayer("1");
                player2 = Player.createPlayer("2");


                System.out.println("\n---------The quiz start---------\n"); //added by Denise
                questionManager.load(); // Added by denise
                //Quiz.startTheQuiz(); // Added by denise
                runQuestionQuiz();

                Thread.sleep(10000);

                player1.addPlayed_Games();
                player2.addPlayed_Games();
                PointHandler.comparePoints(quiz, player1, player2);
                Player.showStats(player1);
                Player.showStats(player2);
                break;
            case "2":
                //quizManager.printAllQuestions();

                System.out.println("[1] ADD QUESTION");
                System.out.println("[2] DELETE QUESTION");
                int inputNumber = scanner.nextInt();

                if (inputNumber == 1) {
                    questionManager.load();//Added by denise - Load the file
                    questionManager.addQuestion();//Added by denise- add question with options and answer
                    questionManager.save(); // Added by denise - save the question, options and answer to the file
                }

                if (inputNumber == 2) {
                    System.out.println("Which question do you want to delete?\n" );
                    questionManager.load();
                    questionManager.printAllQuestions(); // Added by denise - Show all the questions in the questions file
                    //TODO: Delete questions
                    break;
                }
            case "3":
                System.exit(0);
                break;

            default:
                System.out.println("Invalid input, try again");
        }
    }
}
