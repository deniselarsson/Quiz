import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Timer {

    public static void setTimer(){

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        boolean timeoverr = true;
        boolean timer = true;
        LocalTime startTime = LocalTime.now();
        System.out.println("vad heter du? ");
        String answer = "";
        while (timeoverr) {

            for (int i = 0; i < 10; ) {
                answer = scanner.next();
                LocalTime endTime = LocalTime.now();
                Duration duration = Duration.between(startTime, endTime);
                System.out.println(duration.getSeconds() + " Sekunder");
                if (duration.getSeconds() <= 5) {
                    try {

                        Thread.sleep(1000L);
                    }
                    catch (InterruptedException var11) {
                        var11.printStackTrace();
                    }
                    System.out.println(answer);
                    i = 10;
                }
                else {
                    System.out.println("too slow");
                    i = 10;
                }
            }

            timeoverr = false;
        }
    }
}