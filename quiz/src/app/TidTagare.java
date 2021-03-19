package app;

import java.time.Duration;
import java.time.LocalTime;

public class TidTagare{

    LocalTime start;
    LocalTime end;
    long durationTimePlayer1;
    long durationTimePlayer2;

    public void startTimer(){
        start = LocalTime.now();
    }

    public void endTimer(int player){
        end = LocalTime.now();
        if (player == 1){
            durationTimePlayer1 += Duration.between(start, end).getSeconds();
        } else if (player == 2){
            durationTimePlayer2 += Duration.between(start, end).getSeconds();
        }
    }

    public void resetTime(){
        durationTimePlayer1 = 0;
        durationTimePlayer2 = 0;
    }
}