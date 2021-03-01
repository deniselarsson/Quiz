package App.suggestion.q;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class GameInfo {
    GameInfo() {
    }

    public void infoOption() throws IOException {
        Scanner myScan = new Scanner(System.in);
        Timer myTimer = new Timer();
        PlayerManager myPM = new PlayerManager();

            System.out.println("        Choose an option\n");
            System.out.println("-> [1] About");
            System.out.println("-> [2] Rules");
            System.out.println("-> [3] Users");
            System.out.println("-> [0] Return");
            System.out.println(" - - - - - - - - - - - - - - - -");
            int aInput = myScan.nextInt();

            if (aInput == 1) {
                getAbout();
            } else if (aInput == 2) {
                getRules();
            } else if (aInput == 3) {
                myPM.displayPlayers();
            } else {
                return;
        }
        myTimer.pause();
    }

    public void getAbout() throws IOException {
        String about_md = "...\\file\\Info.md";
        Stream<String> tempAbout = Files.lines(Paths.get(about_md));

        tempAbout
                .filter(x -> x.contains("Java"))
                .forEach(System.out::println);
        tempAbout.close();
    }

    public void getRules() throws IOException {
        String rules_md = "...\\file\\Info.md";
        Stream<String> tempRules = Files.lines(Paths.get(rules_md));
        tempRules
                .filter(x -> x.contains("R"))
                .forEach(System.out::println);
        tempRules.close();
    }
}
