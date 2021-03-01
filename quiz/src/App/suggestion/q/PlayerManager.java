package App.suggestion.q;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class PlayerManager {

    public void startUp() throws IOException {
        Scanner myScan = new Scanner(System.in);
        Player myPlayer = new Player();

        while(true) {
            System.out.println("-------------------------------");
            System.out.println("|           WELCOME           |");
            System.out.println("-------------------------------");
            System.out.println("        Choose an option:       \n");
            System.out.println("-> [1] New user");
            System.out.println("-> [2] Load existing user");
            System.out.println("-> [0] Exit game");
            System.out.println(" - - - - - - - - - - - - - - - ");
            char aInput = myScan.next().charAt(0);

            switch (aInput) {
                case '1' -> myPlayer.addPerson();
                case '2' -> displayPlayers();
                case '0' -> System.exit(0);
                default -> System.out.println("Invalid input, try again!");
            }
        }
    }
    public void playerOption() throws IOException {
        Scanner myScan = new Scanner(System.in);
        QuizManager myQM = new QuizManager();

        while (true) {
            System.out.println("Choose an option: \n");
            System.out.println("-> [1] Single player");
            System.out.println("-> [2] Multiplayer");
            System.out.println("-> [0] Return");

            char aInput = myScan.next().charAt(0);

            switch (aInput) {
                case '1' -> myQM.quizOption();
                case '2' -> startUp();
                case '0' -> {
                    return;
                }
            }
        }
    }
    public void displayPlayers() throws IOException {
        Player myPlayer = new Player();
        Timer myTimer = new Timer();
        System.out.println("Previous players");
        for (int index = 0; index < myPlayer.myPlayerList.size(); index++) {
            System.out.println((index + 1) + ". " + myPlayer.myPlayerList.get(index).getName() + " " + myPlayer.myPlayerList.get(index).getAge() + " " + myPlayer.myPlayerList.get(index).getMail() + " " + myPlayer.myPlayerList.get(index).getScore() + " " + myPlayer.myPlayerList.get(index).getPlayed_Games());
        }
        String users_md = "...\\file\\Users.md";
        Stream<String> tempUsers = Files.lines(Paths.get(users_md));
        tempUsers
                .filter(x -> x.contains("?"))
                .forEach(System.out::println);
        tempUsers.close();
        // Metod: Välj användare, byt användare, edit användare. etc.
        myTimer.pause();
    }
}
