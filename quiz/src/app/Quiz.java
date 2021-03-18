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
    //Start the quiz where we read from the serialized object
    public static void runQuestionQuiz(){

        QuizManager questionBase = new QuizManager();
        int i = 0;

        while(i < 6){
            //Load the file
            questionBase.load();
            //get question index 0 which we declare a new variabel currentQuestion
            Question currentQuestion = questionBase.questions.get(i);
            //Print the first question from the file
            QuizManager.printQuestion(currentQuestion);
            //Print the 3 options
            QuizManager.printOptions(currentQuestion.getOptions());
            //Ask the user to write 1-3 for the correct answer
            System.out.println("\nPlease enter you anwear:");
            //Save the user input
            Scanner scan = new Scanner(System.in);
            int userAnswer = Integer.parseInt(scan.nextLine()) - 1;
            //compare the user input is the correct answer
            Option option = currentQuestion.getOptions().get(userAnswer);

            if (option.getIsCorrectAnswer()) {
                System.out.println("CORRECT ANSWER!");

            }
            else {
                System.out.println("WRONG ANSWER");

            }
            i ++;
        }
    }
}

