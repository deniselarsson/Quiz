package App;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Quiz {
    // Klass Quiz
    //Ni ska skapa en klass som håller reda på frågor, svarsalternativ och vilket svarsalternativ som är rätt.

    String questions = "C:\\Users\\Axel\\IdeaProjects\\Quiz\\quiz\\src\\Files\\Questions.txt";
    Stream<String> temp = Files.lines(Paths.get(questions));

    public Quiz() throws IOException {
    }


    public void answerAlternatives() {

    }

    public void getCorrectAnswer(){

    }

    public void getQuestions() throws IOException {


        temp
                //.filter(x -> )
                .forEach(x -> System.out.println(x));
        temp.close();
    }

    //Den ska också innehålla en metod som ska läsa in de serialiserade frågeobjekten från en fil.
    public void readSerializedObjects(){

    }
}

