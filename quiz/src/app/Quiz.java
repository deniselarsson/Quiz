package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Quiz {

    /**********************Axel_Path*******************************************/
    String questions_txt = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Questions.txt";
    String answers_txt = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Answers.txt";
    String options_txt = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Options.txt";

    /**********************Denise_Path*******************************************/
/*  String questions_txt = "C:/Workspace/Quiz/quiz/src/Files/Questions.txt";
    String answers_txt = "C:/Workspace/Quiz/quiz/src/Files//Answers.txt";
    String options_txt = "C:/Workspace/Quiz/quiz/src/Files//Options.txt";*/

    public void answerAlternatives(int alternativeNumber) throws IOException {

        String y = byteToString(options_txt);
        String[] x = y.split(";");
        System.out.println(x[alternativeNumber-1]);
    }

    public void getCorrectAnswer(int questionNumber) throws IOException {

        String y = byteToString(answers_txt);
        String[] x = y.split("\\.");
        System.out.println("Det rätta svaret var: " + x[questionNumber - 1]);

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

    public void getQuestions(int questionNumber) throws IOException {

        String y = byteToString(questions_txt);
        String[] x = y.split(";");
        System.out.println(x[questionNumber - 1]);

    }

    public void startJavaQuiz() throws IOException {
        String myQuiz = "...\\file\\Quiz.md";
        Stream<String> tempQuiz = Files.lines(Paths.get(myQuiz));

        tempQuiz
                .filter(x -> x.contains("Java"))
                .forEach(System.out::println);
        tempQuiz.close();
    }

    //Den ska också innehålla en metod som ska läsa in de serialiserade frågeobjekten från en fil.
    public void readSerializedObjects(){

    }
}

