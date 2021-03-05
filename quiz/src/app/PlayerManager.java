package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class PlayerManager {
    // ***** [2] FIRST METHOD WITH MENU OPTIONS ***** //
    /* Method named startUp */
    public void startUp() throws IOException {
        /* Objects created from
        a. library class SCANNER named mySc
        b. class Player named myP */
        Scanner mySc = new Scanner(System.in);
        Player myP = new Player();

        /* While loop introducing menu layout explaining the available options for the user */
        while(true) {
            System.out.println("-------------------------------");
            System.out.println("|           WELCOME           |");
            System.out.println("-------------------------------");
            System.out.println("        Choose an option:       \n");
            System.out.println(" [1] New user");
            System.out.println(" [2] Load existing user");
            System.out.println(" [0] Exit game");
            System.out.println(" - - - - - - - - - - - - - - - ");

            /* A character variable created named aInput for reading the option the user make */
            char aInput = mySc.next().charAt(0);

            /* A switch case that, depending on which option the user make, run different methods */
            switch (aInput) {
                /* Case 1 forward the user to the method addPerson in class Player through our created object named myP */
                case '1' -> myP.addPerson();
                /* Case 2 forward the user to the method displayPlayers below */
                case '2' -> displayPlayers();
                /* Case 0 enable the user to exit the program safely */
                case '0' -> System.exit(0);
                /* This command enable the user to try again if aInput doesnt match any of the alternatives above */
                default -> System.out.println("Invalid input, try again!");
            }
        }
    }

    /* A method called playerOption which enables the player to start a quiz alone or with another player */
    public void playerOption() throws IOException {
        /* Objects created from
        a. library class SCANNER named mySc
        b. class QuizManager named myQM */
        Scanner mySc = new Scanner(System.in);
        QuizManager myQM = new QuizManager();

        /* While loop introducing menu layout explaining the options for the user */
        while (true) {
            System.out.println("Choose an option: \n");
            System.out.println("-> [1] Single player");
            System.out.println("-> [2] Multiplayer");
            System.out.println("-> [0] Return");

            /* A character variable created named aInput for reading the option the user make */
            char aInput = mySc.next().charAt(0);

            /* A switch case that, depending on which option the user make, run different methods */
            switch (aInput) {
                /* Case 1 forward the user to the method quizOption in class QuizManager through our created object named myQM */
                case '1' -> myQM.quizOption();
                /* Case 2 forward the user to the method multiPlayers below */
                case '2' -> multiPlayer();
                /* Case 0 enable the user to return to the previous menu in the program safely w/o the need to restart the quiz */
                case '0' -> {
                    return;
                }
                /* This command enable the user to try again if aInput doesnt match any of the alternatives above */
                default -> System.out.println("Invalid input, try again!");
            }
        }
    }

    /* A method called multiPlayer which enables the user to enter player 2 as a new user or choose an existing user to play with b4 starting the quiz */
    public void multiPlayer() throws IOException {
        /* Objects created from
        a. library class SCANNER named mySc
        b. class Player named myP
        c. class QuizManager named myQM */
        Scanner mySc = new Scanner(System.in);
        Player myP = new Player();
        QuizManager myQM = new QuizManager();

        /* While loop introducing menu layout explaining the options for the user */
        while(true) {
            System.out.println("        Choose an option for player 2:       \n");
            System.out.println("--> [1] New user");
            System.out.println("--> [2] Load existing user");
            System.out.println("--> [0] Return");
            System.out.println(" - - - - - - - - - - - - - - - ");

            /* A character variable created named aInput for reading the option the user make */
            char aInput = mySc.next().charAt(0);

            /* A switch case that, depending on which option the user make, run different methods */
            switch (aInput) {
                /* Case 1 forward the user to the method addPerson in class Player through our created object named myP */
                case '1' -> myP.addPerson();
                /* Case 2 forward the user to the method displayPlayers below */
                case '2' -> displayPlayers();
                /* Case 0 enable the user to return to the previous menu in the program safely w/o need to restart the quiz */
                case '0' -> {
                    return;
                }
                /* This command enable the user to try again if aInput doesnt match any of the alternatives above */
                default -> System.out.println("Invalid input, try again!");
            }
            /* This command forward the program to the method quizOption in class QuizManager through our created object named myQM */
            myQM.quizOption();
        }
    }
    /* A method called displayPlayers which enables the user to load a list of existing players */
    public void displayPlayers() throws IOException {
        /* Objects created from
        a. class Player named myP
        c. class Timer named myT */
        Player myP = new Player();
        Timer myT = new Timer();

        /* Heading for list of users */
        System.out.println("Previous players");

        /* A try to give each player a number in fromt of their name, enabling the user to choose which player by entering the number in front of the name */
        for (int index = 0; index < myP.myPlayerList.size(); index++) {
            System.out.println((index + 1) + ". " + myP.myPlayerList.get(index).getName() + " " + myP.myPlayerList.get(index).getAge() + " " + myP.myPlayerList.get(index).getMail() + " " + myP.myPlayerList.get(index).getScore() + " " + myP.myPlayerList.get(index).getPlayed_Games());
        }
        /* A try to serialize the list of players from an .md file */
        String users_md = "C:\\Users\\cakeDiv\\Desktop\\Quiz-dev\\Quiz-dev\\quiz\\src\\Files\\Users.md";
        Stream<String> tempUsers = Files.lines(Paths.get(users_md));
        tempUsers
                .filter(x -> x.contains("?"))
                .forEach(System.out::println);
        tempUsers.close();
        /* This command pauses the program, disable it from continuing to run with help from the method pause in class Timer through our created object named myT */
        myT.pause();
    }
}