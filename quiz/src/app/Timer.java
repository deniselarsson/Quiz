package app;

import java.io.IOException;
import java.util.TimerTask;

public class Timer {

    Quiz quiz = new Quiz();
    java.util.Timer timer = new java.util.Timer();

    public  void timer(int questionNumber) {
        System.out.println("You have 5 seconds to answer:");
        timer.schedule(new TimerTask() {
            // variabel för antalet sekunder per fråga
            int sec = 6;
            @Override
            public void run() {
                sec--;
                /*System.out.print("\b\b\b\b\b\b\b\b");
                System.out.print(sec);*/
                if (sec == 0){
                    System.out.print("\b");
                    System.out.println("TIME'S UP!");
                    // Stannar timern ifall tiden tar slut
                    timer.cancel();
                    // Gör så att tråden går vidare till nästa metod och jämför svaret
                    try {
                        quiz.getCorrectAnswer(questionNumber, "fel");
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