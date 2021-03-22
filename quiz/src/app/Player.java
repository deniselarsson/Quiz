package app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player extends Person {

    int score = 0;
    int played_games = 0;

    Player (String newName, int newAge, String newMail, int score, int played_games) {
        super(newName, newAge, newMail);
        this.score = score;
        this.played_games = played_games;
    }

    public Player () {
        super();
    }

    public void addScore () {
        score++;
    }

    public void addPlayed_Games () {
        played_games++;
    }

    public void showStats () {
        System.out.println();
        System.out.println(name + " has played " + played_games + " games and won " + score + " games");
    }

    public static Player createPlayer (String playerNumber) {

        Scanner scanner = new Scanner(System.in);

        String name = null;
        int age = 0;
        String mail = null;

        String regexName = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";
        Pattern patternName = Pattern.compile(regexName);

        System.out.println("------Insert info for player " + playerNumber + "------");

        int y = 0;
        while (y == 0) {
            System.out.print("Name:");
            name = scanner.nextLine();

            Matcher matcher = patternName.matcher(name);

            if (matcher.matches()) {
                y++;
            }
            else {
                System.out.print("Not valid, try again");
            }
        }

        int i = 0;
        while (i == 0) {
            System.out.print("Age: ");
            String x = scanner.next();
            try {
                age = Integer.parseInt(x);
                if (age <= 0) {
                    System.out.print("Too young, try again");
                }
                else {
                    i++;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Not valid, try again");
            }
        }

        String regexMail = "^(.+)@(.+)$";
        Pattern patternMail = Pattern.compile(regexMail);

        int x = 0;
        while (x == 0) {
            System.out.print("Mail: ");
            mail = scanner.next();

            Matcher matcher = patternMail.matcher(mail);

            if (matcher.matches()) {
                x++;
            }
            else {
                System.out.println("Not valid, try again");
            }
        }

        int score = 0;
        int played_games = 0;

        Player temp = new Player(name, age, mail, score, played_games);
        return temp;
    }
}

