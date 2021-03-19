package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PointManager {

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

    public static void comparePoints(PointManager quiz, Player player1, Player player2){
        if (quiz.player1Correct > quiz.player2Correct){
            player1.addScore();
            System.out.println("Congratulations " + player1.name + " you won");
        } else if (quiz.player1Correct < quiz.player2Correct){
            player2.addScore();
            System.out.println("Congratulations " + player2.name + " you won");
        } else {
            System.out.println("EVEN AMOUNT OF POINTS");
        }
    }
}
