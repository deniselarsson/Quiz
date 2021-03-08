package app;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.TimerTask;

public class Timer {

    Quiz quiz = new Quiz();
    java.util.Timer timer = new java.util.Timer();

    public  void timer(int questionNumber) {
        System.out.println("You have 5 seconds to answer");
        timer.schedule(new TimerTask() {
            int i = 6;
            @Override
            public void run() {
                i--;
                /*System.out.print("\b\b\b\b\b\b");
                System.out.print(i);*/
                if (i == 0){
                    System.out.print("\b");
                    System.out.println("TIME'S UP!");
                    timer.cancel();
                    try {
                        quiz.getCorrectAnswer(questionNumber, 'f');
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 0, 1000);
    }
    public void timerStop(){
        timer.cancel();
    }

}