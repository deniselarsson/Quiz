package App;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Quiz {
    // Klass Quiz
    //Ni ska skapa en klass som håller reda på frågor, svarsalternativ och vilket svarsalternativ som är rätt.


    public Quiz() throws IOException {
    }


    public void answerAlternatives(String alternativeNumber) throws IOException {
        //String questions = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Questions.txt";
        String questions = "C:/Workspace/Quiz/quiz/src/Files/Questions";
        Stream<String> tempAnswer = Files.lines(Paths.get(questions));


        tempAnswer
                .filter(x -> x.contains(alternativeNumber + "A") || x.contains(alternativeNumber +"B") || x.contains(alternativeNumber +"C") || x.contains(alternativeNumber + "D"))
                .forEach(x -> System.out.println(x));
        tempAnswer.close();

    }

    public void getCorrectAnswer(String answerNumber) throws IOException {
        String questions = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Questions.txt";
        Stream<String> tempAnswer = Files.lines(Paths.get(questions));

        tempAnswer
                .filter(x -> x.contains(answerNumber + " " + "ANSWER"))
                .forEach(x -> System.out.println(x));
        tempAnswer.close();
    }

    public void getQuestions(String questionNumber) throws IOException {
        String questions = "C:/Users/Axel/IdeaProjects/Quiz/quiz/src/Files/Questions.txt";
        Stream<String> tempQuestion = Files.lines(Paths.get(questions));

        tempQuestion
                .filter(x -> x.contains("?") && x.contains(questionNumber))
                .forEach(x -> System.out.println(x));
        tempQuestion.close();
    }

    //Den ska också innehålla en metod som ska läsa in de serialiserade frågeobjekten från en fil.
    public void readSerializedObjects(){}
 
}

