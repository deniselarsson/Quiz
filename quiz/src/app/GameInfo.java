package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class GameInfo {
    /* An empty constructor */
    GameInfo() {}

    /* A method named infoOption showing the option menu for the user */
    public void infoOption() throws IOException {
        /* Objects created from
        a. library class SCANNER named mySc
        b. class Timer named myT
        c. class PlayerManager named myPM */
        Scanner mySc = new Scanner(System.in);
        Timer myT = new Timer();
        PlayerManager myPM = new PlayerManager();

        /* Option menu */
        System.out.println("        Choose an option\n");
        System.out.println("-> [1] About");
        System.out.println("-> [2] Rules");
        System.out.println("-> [3] Users");
        System.out.println("-> [0] Return");
        System.out.println(" - - - - - - - - - - - - - - - -");

        /* A int variable created named aInput for reading the option the user make */
        int aInput = mySc.nextInt();
        /* A if else loop that, depending on which option the user make, run different methods */
        if (aInput == 1) {
            getAbout(); /* If the input is 1 the program runs the method getAbout */
        } else if (aInput == 2) {
            getRules(); /* If the input is 2 the program runs the method getRules */
        } else if (aInput == 3) {
            myPM.displayPlayers(); /* If the input is 3 the program runs the method displayPlayers in class PlayerManager through our created object named myPM */
        } else {
            return; /* Case 0 enable the user to return to the previous menu in the program safely w/o the need to restart the quiz */
        }
        /* This command pauses the program, disable it from continuing to run with help from the method pause in class Timer through our created object named myT */
        myT.pause();
    }
    /* A method named getAbout showing the information about the game project for the user from a file named Info.md */
    public void getAbout() throws IOException {
        String about_md = "C:\\Users\\cakeDiv\\Desktop\\Quiz-dev\\Quiz-dev\\quiz\\src\\Files\\Info.md";
        Stream<String> tempAbout = Files.lines(Paths.get(about_md));

        tempAbout
                .filter(x -> x.contains("d"))
                .forEach(System.out::println);
        tempAbout.close();
    }

    /* A method named getRules showing the information about the game rules for the user from a file named Info.md */
    public void getRules() throws IOException {
        String rules_md = "C:\\Users\\cakeDiv\\Desktop\\Quiz-dev\\Quiz-dev\\quiz\\src\\Files\\Info.md";
        Stream<String> tempRules = Files.lines(Paths.get(rules_md));
        tempRules
                .filter(x -> x.contains("R"))
                .forEach(System.out::println);
        tempRules.close();
    }
}