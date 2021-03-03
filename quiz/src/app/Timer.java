package app;

public class Timer {
    // Timer 30 sek to answer each question
    // When time is up, write out "TIME OUT" + score points (compared between player 1 and 2)

    public void pause() {
        System.out.println("Press any key to continue");
        new java.util.Scanner(System.in).nextLine();
    }
}
