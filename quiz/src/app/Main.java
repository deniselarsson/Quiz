package app;

import java.util.Scanner;

public class Main {
    public static void main (String []args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        PointManager pointManager = new PointManager();
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
                QuizManager.startTheQuiz();
                Thread.sleep(1000);

                player1.addPlayed_Games();
                player2.addPlayed_Games();
                PointManager.comparePoints(pointManager, player1, player2);
                Player.showStats(player1);
                Player.showStats(player2);
                break;

            case "2":
                System.out.println("[1] ADD QUESTION");
                System.out.println("[2] DELETE QUESTION");
                System.out.println("[3] LIST ALL QUESTIONS ");
                int inputNumber = scanner.nextInt();

                if (inputNumber == 1) {
                    questionManager.load();
                    questionManager.addQuestion();
                    questionManager.save();
                }

                if (inputNumber == 2) {
                    System.out.println("Which question do you want to delete?\n" );
                    questionManager.load();
                    questionManager.printAllQuestions();
                    //TODO: Delete questions
                    break;
                }
                if (inputNumber == 3) {
                    questionManager.load();
                    questionManager.printAllQuestions();
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
