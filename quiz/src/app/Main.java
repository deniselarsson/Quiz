package app;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main (String []args) throws IOException, InterruptedException {



        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("WELCOME");
        System.out.println("[1] PLAY");
        System.out.println("[2] QUIZZES");
        System.out.println("[3] EXIT");
        String input = scanner.nextLine();


        switch (input){
            case "1":
                /*player1 = Player.createPlayer("1");
                player2 = Player.createPlayer("2");*/
                startQuiz(1);
                Player.showStats(player1);
                Player.showStats(player2);
                break;
            case "2":
                System.out.println("Quiz time");
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input, try again");
        }
    }

    public static void startQuiz(int i) throws IOException, InterruptedException {
        Quiz quiz = new Quiz();
        for ( ;i < 6; i++){
            quiz.getQuestions(i);
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
