package app;

import java.time.Duration;
import java.time.LocalTime;

public class Hourglass extends Thread{

    LocalTime start;
    LocalTime end;
    static long durationTimePlayer1;
    static long durationTimePlayer2;

    /*public void resetTime () {

    public void resetTime () {

        durationTimePlayer1 = 0;
        durationTimePlayer2 = 0;
    }*/

    @Override
    public void run() {
        durationTimePlayer1 = 0;
        durationTimePlayer2 = 0;
        System.out.println("Multithreading funkar");
    }

    public void startTimer () {
        start = LocalTime.now();
    }

    public void endTimer (int player) {
        end = LocalTime.now();
        if (player == 1) {
            durationTimePlayer1 += Duration.between(start, end).getSeconds();
        }
        else if (player == 2) {
            durationTimePlayer2 += Duration.between(start, end).getSeconds();
        }
    }
}