package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Quiz {

    int player1Correct = 0;
    int player2Correct = 0;

    // När man startar quizet resetas pointsen
    public void resetPoints(){
        player1Correct = 0;
        player2Correct = 0;
    }

    Scanner scanner = new Scanner(System.in);

    String questions_txt = "C:\\Users\\Axel\\IdeaProjects\\Quiz\\quiz\\src\\files\\Questions.txt";
    String answers_txt = "C:\\Users\\Axel\\IdeaProjects\\Quiz\\quiz\\src\\files\\Answers.txt";
    String options_txt = "C:\\Users\\Axel\\IdeaProjects\\Quiz\\quiz\\src\\files\\Options.txt";

    // Startar quiz och loopar så att den går igenom alla 6 frågor
    public void startQuiz(int i) throws IOException, InterruptedException {
        resetPoints();
        for ( ;i < 7; i++){
            getQuestions(i);
        }
    }

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
            if (questionNumber % 2 == 0){
                player2Correct++;
            } else {
                player1Correct++;
            }
        } else {
            System.out.println("Fel, rätt svar var: " + lastWord);
            System.out.println();
        }

        // Sleepar threaden så att spelare har tid att förbereda sig inför nästa fråga
        if (questionNumber < 6){
            System.out.println("Now the next question is coming, get ready!");
        } else{
            System.out.println("We're finished!");
        }

        Thread.sleep(3000);
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

