package app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player extends Person {

    int matchScore = 0;
    int played_games = 0;

    Player(String newName, int newAge, String newMail, int score, int played_games) {
        super(newName, newAge, newMail);
    }

    public Player() {
        super();
    }


    public void addScore(){
        matchScore++;
    }

    public void addPlayed_Games(){
        played_games++;
    }

    public void countNumber(){
        played_games++;
    }



    public static void showStats(Player player){
        player.addPlayed_Games();
        System.out.println(player.name + " has played "+ player.played_games + " games");
        System.out.println();
    }

    // Method that creates attributes for objects of the Player Class and then returns them in Object form
    // Use like this:
    // Player object = createPlayer("playernumber")
    // or if already initialized like this:
    // Player player1 = new Player();    player1 = createPlayer("1");
    public static Player createPlayer(String playerNumber) {
        Scanner scanner = new Scanner(System.in);

        String name = null;
        int age = 0;
        String mail = null;

        // Loop, regex pattern and validation for name input
        String regexName = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";
        Pattern patternName = Pattern.compile(regexName);

        System.out.println("Insert info for player " + playerNumber);

        int y = 0;
        while (y == 0) {
            System.out.println("Name:");
            name = scanner.nextLine();

            Matcher matcher = patternName.matcher(name);

            if (matcher.matches()) {
                y++;
            } else {
                System.out.println("Not valid, try again");
            }
        }

        // Loop and input validation for age
        int i = 0;
        while (i == 0) {
            System.out.println("Age: ");
            String x = scanner.next();
            try {
                age = Integer.parseInt(x);
                if (age <= 0) {
                    System.out.println("Too young, try again");
                } else {
                    i++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Not valid, try again");
            }
        }

        // Loop, regex pattern and validation for mail
        String regexMail = "^(.+)@(.+)$";
        Pattern patternMail = Pattern.compile(regexMail);

        int x = 0;
        while (x == 0) {
            System.out.println("Mail: ");
            mail = scanner.next();

            Matcher matcher = patternMail.matcher(mail);

            if (matcher.matches()) {
                x++;
            } else {
                System.out.println("Not valid, try again");
            }
        }

        int score = 0;
        int played_games = 0;

        Player temp = new Player(name, age, mail, score, played_games);
        return temp;
    }

}

