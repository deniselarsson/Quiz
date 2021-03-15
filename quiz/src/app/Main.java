package app;

import serialization.FileHandler;
import serialization.Question;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String []args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();

        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("WELCOME");
        System.out.println("[1] PLAY");
        System.out.println("[2] QUIZZES");
        System.out.println("[3] EXIT");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                player1 = Player.createPlayer("1");
                player2 = Player.createPlayer("2");
                quiz.startQuiz(1);
                player1.addPlayed_Games();
                player2.addPlayed_Games();
                comparePoints(quiz, player1, player2);
                Player.showStats(player1);
                Player.showStats(player2);
                break;
            case "2":
                System.out.println("[1] Add Question");
                System.out.println("[2] delete Question");
                int inputNumber = scanner.nextInt();

                if (inputNumber == 1) {
                    Question.setNewQuestion();
                }
                //Om använadren skriver in 2 visa alla frågor och fråga vilken dem vill radera
                if (inputNumber == 2) {
                    System.out.println("Which question do you want to delete?");
                    Question.printAllQuestions(FileHandler.readQuestions());
                    break;
                }
            case "3":
                System.exit(0);
                break;

            default:
                System.out.println("Invalid input, try again");
        }
    }

    public static void comparePoints(Quiz quiz, Player player1, Player player2){
        if (quiz.player1Correct > quiz.player2Correct){
            player1.addScore();
            System.out.println("Congratulations " + player1.name + " you won");
        } else if (quiz.player1Correct < quiz.player2Correct){
            player2.addScore();
            System.out.println("Congratulations " + player2.name + " you won");
        } else {
            System.out.println("EVEN AMOUNT OF POINTS");
        }
    }

}



    /* 1. Välkomstmeny (Lägg som meny 2)
    *       a. PLAY
    *           - Player 1 : namn, ålder, mail
    *           - Player 2 : namn, ålder, mail
    *               -> Starta quiz 6 frågor
    *                   -> Visa score och played games
    *       b. Redigera quiz
    *           - add
    *           - remove
    *           - edit
    *               -> ask for correct answers
    *       c. Exit game
    * */
