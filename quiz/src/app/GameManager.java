package app;

import java.io.IOException;
import java.util.Scanner;

public class GameManager {
    // Read even number of questions (least 6)
    // Present one to each player taking turns
    // count number of points each player get (+1 for each correct answer)

    public void playOption() throws IOException {
        Scanner myScan = new Scanner(System.in);
        GameInfo myGI = new GameInfo();
        PlayerManager myPM = new PlayerManager();

        while (true) {
            System.out.println("        Choose an option       \n");
            System.out.println(" [1] PLAY");
            System.out.println(" [2] About");
            System.out.println(" [3] Logout");
            System.out.println(" [0] Exit");
            System.out.println(" - - - - - - - - - - - - - - - ");
            char aInput = myScan.next().charAt(0);

            switch (aInput) {
                case '1' -> myPM.playerOption();
                case '2' -> myGI.infoOption();
                case '3' -> myPM.startUp();
                case '0' -> System.exit(0);
                default -> System.out.println("Invalid input, try again!");
            }
        }
    }
}