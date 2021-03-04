package app;

import java.io.IOException;

public class Timer {
    // Timer 30 sek to answer each question
    // When time is up, write out "TIME OUT" + score points (compared between player 1 and 2)

    /* A method called pause to hold the program waiting for an input of any kind b4 continuing to run next part */
    public void pause() throws IOException {
        System.out.println("Press any key to continue");
        new java.util.Scanner(System.in).nextLine();
    }
}