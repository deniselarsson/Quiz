package App.suggestion.q;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Quiz {
    // Questions
    // Answers

    // Correct answer
    // Read serialized question objects

    Quiz(){}

    public void startJavaQuiz() throws IOException {
        String myQuiz = "...\\file\\Quiz.md";
        Stream<String> tempQuiz = Files.lines(Paths.get(myQuiz));

        tempQuiz
                .filter(x -> x.contains("Java"))
                .forEach(System.out::println);
        tempQuiz.close();
    }
}