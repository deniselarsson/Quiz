package App;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Quiz {

    //Ni ska skapa en klass som håller reda på frågor, svarsalternativ och vilket svarsalternativ som är rätt.


    String filename = "C:\\Users\\cakeDiv\\Documents\\workspace\\00_2 GitHubRepositories\\Quiz\\quiz\\src\\Files\\Questions";
    Stream<String> temp = Files.lines(Paths.get(filename));

    public Quiz() throws IOException {
    }

    public void userInput() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Choose your input: ");
        String userInput = myScanner.nextLine();

        System.out.println(userInput);
    }

    public String getCorrectAnswers() {
        Stream<String> tempAnswer = Files.lines(Paths.get(answer_txt));
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Choose your answer: ");
        String userInput = myScanner.nextLine();

        tempAnswer
                .filter(x -> x.contains(answerNumber + " " + "ANSWER"))
                .forEach(x -> System.out.println(x));
                tempAnswer.close();
    }

    public void getQuestions() throws IOException{
        Stream<String> tempQuestion = Files.lines(Paths.get(questions_txt));

        temp
                .filter(x -> x.contains("1"))
                .forEach(x -> System.out.println(x));

        temp.close();
    }

    public void readSerializedObjects() {

    }

    //Den ska också innehålla en metod som ska läsa in de serialiserade frågeobjekten från en fil.
    public void answerAlternatives() {

    }
}