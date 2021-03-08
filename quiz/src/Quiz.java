import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Quiz {

    /**********************Axel_Path*******************************************/
/*    String questions_txt = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Questions.txt";
    String answers_txt = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Answers.txt";
    String options_txt = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Options.txt";*/

    /**********************Denise_Path*******************************************/
    String questions_txt = "C:/Workspace/Quiz/quiz/src/files/Questions.txt";
    String answers_txt = "C:/Workspace/Quiz/quiz/src/files/Answers.txt";
    String options_txt = "C:/Workspace/Quiz/quiz/src/files/Options.txt";

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
}
