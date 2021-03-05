package app;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main (String []args) {
        Scanner mySc = new Scanner(System.in);

        while (true) {
            System.out.println("WELCOME");
            System.out.println("[1] PLAY");
            System.out.println("[2] QUIZZES");
            System.out.println("[0] EXIT");
            char aInput = mySc.next().charAt(0);
            switch (aInput) {
                case '1' -> /*Lägg till player 1 sen player 2 metod*/;
                case '2' -> /* quizzes */;
                case '3' -> System.exit(0);
                default -> System.out.println("Invalid input, try again!");
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
}