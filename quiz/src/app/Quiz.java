package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Quiz {

    Scanner scanner = new Scanner(System.in);

    String questions_txt = "C:\\Users\\Axel\\Desktop\\Skolrelaterat\\Quiz-Felicia\\quiz\\src\\files\\Questions.txt";
    String answers_txt = "C:\\Users\\Axel\\Desktop\\Skolrelaterat\\Quiz-Felicia\\quiz\\src\\files\\Answers.txt";
    String options_txt = "C:\\Users\\Axel\\Desktop\\Skolrelaterat\\Quiz-Felicia\\quiz\\src\\files\\Options.txt";

    // Skriver ut frågan från textfilen
    public void getQuestions(int questionNumber) throws IOException, InterruptedException {

        String y = byteToString(questions_txt);

        String[] x = y.split(";");

        System.out.println(x[questionNumber - 1]);

        // Kallar på alterantivsmetoden
        answerAlternatives(questionNumber);
    }

    // Skriver ut alternativen men startar och stoppar också timern
    public void answerAlternatives(int alternativeNumber) throws IOException, InterruptedException {

        String y = byteToString(options_txt);

        String[] x = y.split(";");

        System.out.println(x[alternativeNumber-1]);

        Timer timer = new Timer();

        // Startar timermetoden
        timer.timer(alternativeNumber);

        String userAnswer = scanner.nextLine();

        // Ifall svar kommer in stoppas timern
        timer.timerStop();

        // kallar på korrekt svar metoden
        getCorrectAnswer(alternativeNumber, userAnswer);

    }

    // Skriver ut och jämför om det var rätt svar
    public void getCorrectAnswer(int questionNumber, String userAnswer) throws IOException, InterruptedException {

        String y = byteToString(answers_txt);

        String[] x = y.split("\\.");


        String lastWord = x[questionNumber - 1].substring(x[questionNumber - 1].lastIndexOf(" ")+1);
        //char lastWord = lastWord1.charAt(0);

        if (userAnswer.equals(lastWord)){
            System.out.println("Rätt!");
            System.out.println();
        } else {
            System.out.println("Fel, rätt svar var: " + lastWord);
            System.out.println();
        }

        // Sleepar threaden så att spelare har tid att förbereda sig inför nästa fråga
        System.out.println("Now the next question is coming, get ready!");
        Thread.sleep(5000);
        Main.startQuiz(questionNumber + 1);

    }

    private static String byteToString(String filePath)
    {
        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return content;

    }

}

