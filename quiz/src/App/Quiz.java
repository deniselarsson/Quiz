package App;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Quiz {
    // Klass Quiz
    //Ni ska skapa en klass som håller reda på frågor, svarsalternativ och vilket svarsalternativ som är rätt.
    Scanner scanner = new Scanner(System.in);


    String questions_txt = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Questions.txt";
    String answers_txt = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Answers.txt";
    String options_txt = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Options.txt";

    public void answerAlternatives(String alternativeNumber) throws IOException {

        Stream<String> tempAnswer = Files.lines(Paths.get(options_txt));

        tempAnswer
                .filter(x -> x.contains(alternativeNumber + "A") || x.contains(alternativeNumber +"B") || x.contains(alternativeNumber +"C") || x.contains(alternativeNumber + "D"))
                .forEach(x -> System.out.println(x));
        tempAnswer.close();

    }


    public void getCorrectAnswer(String questionNumber) throws IOException {

        String y = readAllBytesJava7(answers_txt);

        String[] x = y.split("\\.");

        int questionNumberParsed = Integer.parseInt(questionNumber);

        System.out.println("Det rätta svaret var: " + x[questionNumberParsed]);

    }

    private static String readAllBytesJava7(String filePath)
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

        /*Stream<String> tempAnswer = Files.lines(Paths.get(answers_txt));

        System.out.println("Choose your answer");
        String userInput = scanner.nextLine();

        tempAnswer
                .filter(x -> { boolean y;
                    y = x.contains(answerNumber + " " + "ANSWER");
                    System.out.println(y);
                    return y;
                });
                //.forEach(x -> System.out.println(x));
        tempAnswer.close();
        */
    }

    public void getQuestions(String questionNumber) throws IOException {
        Stream<String> tempQuestion = Files.lines(Paths.get(questions_txt));

        tempQuestion
                .filter(x -> x.contains("?") && x.contains(questionNumber))
                .forEach(x -> System.out.println(x));
        tempQuestion.close();
    }

    //Den ska också innehålla en metod som ska läsa in de serialiserade frågeobjekten från en fil.
    public void readSerializedObjects(){

    }
}

