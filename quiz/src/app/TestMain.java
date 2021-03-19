package app;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {

    public static void main (String[] args) {

        //test1();

        Scanner scanner = new Scanner(System.in);
        Hourglass hourglass = new Hourglass();

        System.out.println("Fråga 1");
        hourglass.startTimer();
        scanner.nextInt();
        hourglass.endTimer(1);

        System.out.println("Fråga 2");
        hourglass.startTimer();
        scanner.nextInt();
        hourglass.endTimer(2);

        System.out.println(Hourglass.durationTimePlayer1);
        System.out.println(Hourglass.durationTimePlayer2);



    }
    public static void test1 () {

        QuestionManager questionManager = new QuestionManager();
        questionManager.load();
        QuizManager quizManager = new QuizManager(questionManager.questions);
        ArrayList<Player> players = new ArrayList<>();

        ///
     /*   Player player1 = new Player();
        player1.name = "Denise";
        players.add(player1);
        Player player2 = new Player();
        player2.name = "Micke";
        players.add(player2);
        ///*/

        players.add(Player.createPlayer("1"));
        players.add(Player.createPlayer("2"));

        for (int i = 0; i < 3; i++) {
            for (Player player : players) {

                System.out.println("Player: " + player.name);
                Question question = quizManager.getNextQuestion();
                QuestionManager.printQuestion(question);
                QuestionManager.printOptions(question.getOptions());
                System.out.println("\nPlease enter you answer:");

                Scanner scan = new Scanner(System.in);
                int userAnswer = Integer.parseInt(scan.nextLine()) - 1;

                if (QuizManager.isCorrectAnswer(question, userAnswer)) {
                    System.out.println("CORRECT ANSWER!");
                }
                else {
                    System.out.println("WRONG ANSWER");
                }
            }

        }
    }
}
