package app;

import java.io.IOException;
import java.util.Scanner;

public class GameManager {
    // Read even number of questions (least 6)
    // Present one to each player taking turns
    // count number of points each player get (+1 for each correct answer)

    /*  */
    /* Method named playerOption */
    public void playOption() throws IOException {
        /* Objects created from
        a. library class SCANNER named mySc
        b. class GameInfo named myGI
        c. class PlayerManager named myPM */
        Scanner mySc = new Scanner(System.in);
        GameInfo myGI = new GameInfo();
        PlayerManager myPM = new PlayerManager();

        /* While loop introducing menu layout explaining the available options for the user */
        while (true) {
            System.out.println("        Choose an option       \n");
            System.out.println(" [1] PLAY");
            System.out.println(" [2] About");
            System.out.println(" [3] Logout");
            System.out.println(" [0] Exit");
            System.out.println(" - - - - - - - - - - - - - - - ");

            /* A character variable created named aInput for reading the option the user make */
            char aInput = mySc.next().charAt(0);

            /* A switch case that, depending on which option the user make, run different methods */
            switch (aInput) {
                /* Case 1 forward the user to the method playerOption in class PlayerManager through our created object named myPM */
                case '1' -> myPM.playerOption();
                /* Case 2 forward the user to the method infoOption in class GameManager through our created object named myGM */
                case '2' -> myGI.infoOption();
                /* Case 3 forward the user to the method startup in class PlayerManager through our created object named myPM */
                case '3' -> myPM.startUp();
                /* Case 0 enable the user to exit the program safely */
                case '0' -> System.exit(0);
                /* This command enable the user to try again if aInput doesnt match any of the alternatives above */
                default -> System.out.println("Invalid input, try again!");
            }
        }
    }
}