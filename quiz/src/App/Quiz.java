package App;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Quiz {

    //Ni ska skapa en klass som håller reda på frågor, svarsalternativ och vilket svarsalternativ som är rätt.


        String filename = "C:/ECutbildning/Avancerad Java/Inlämningsuppgifter/Quiz.git/quiz/src/Files/Questions";
        Stream<String> temp = Files.lines(Paths.get(filename));

    public Quiz() throws IOException {
    }


    public void getCorrectAnswers() {

    }

    public void getQuestions() throws IOException{



        temp
                .filter(x -> x.contains("?"))

                .forEach(x -> System.out.println(x));

        temp.close();
    }

    public void readSerializedObjects() {

    }

    //Den ska också innehålla en metod som ska läsa in de serialiserade frågeobjekten från en fil.
    public void answerAlternatives() {

    }
}

