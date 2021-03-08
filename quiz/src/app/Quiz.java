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

    public void getQuestions(int questionNumber) throws IOException, InterruptedException {

        String y = byteToString(questions_txt);

        String[] x = y.split(";");

        System.out.println(x[questionNumber - 1]);

        answerAlternatives(questionNumber);
    }


    public void answerAlternatives(int alternativeNumber) throws IOException, InterruptedException {

        String y = byteToString(options_txt);

        String[] x = y.split(";");

        System.out.println(x[alternativeNumber-1]);

        Timer timer = new Timer();

        timer.timer(alternativeNumber);
        char userAnswer = scanner.nextLine().charAt(0);
        timer.timerStop();


        getCorrectAnswer(alternativeNumber, userAnswer);

    }


    public void getCorrectAnswer(int questionNumber, char userAnswer) throws IOException, InterruptedException {

        String y = byteToString(answers_txt);

        String[] x = y.split("\\.");


        String lastWord1 = x[questionNumber - 1].substring(x[questionNumber - 1].lastIndexOf(" ")+1);
        char lastWord = lastWord1.charAt(0);

        if (userAnswer == lastWord){
            System.out.println("Rätt!");
            System.out.println();
        } else {
            System.out.println("Fel, rätt svar var: " + lastWord);
            System.out.println();
        }

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

