package app;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class QuizManager{

    static int player1Correct = 0;
    static int player2Correct = 0;

    public static void resetPoints () {
        player2Correct = 0;
        player1Correct = 0;
    }

    private ArrayList<Question> questions;

    public QuizManager (ArrayList<Question> questions) {
        this.questions = new ArrayList<>(questions);
    }

    public Question getNextQuestion () {
        Random random = new Random();
        Integer index = random.nextInt(questions.size() - 1);
        Question question = questions.get(index);
        this.questions.remove(question);
        return question;
    }

    public static boolean isCorrectAnswer (Question question, Integer index) {
        return question.getOptions().get(index).getIsCorrectAnswer();
    }

    public static void startTheQuiz (Player player1, Player player2) throws InterruptedException {
        Hourglass hourglass = new Hourglass();
        Thread hourglass1 = new Hourglass();
        hourglass1.start();
        resetPoints();

        QuestionManager questionManager = new QuestionManager();
        questionManager.load();
        QuizManager quizManager = new QuizManager(questionManager.questions);
        ArrayList<Player> players = new ArrayList<>();

        players.add(player1);
        players.add(player2);

        System.out.println("\n---------The quiz start---------");

        for (int i = 0; i < 3; i++) {
            for (Player player : players) {

                System.out.println("\u001B[0m" + "\nPlayer: " + player.name + "\u001B[0m");
                Question question = quizManager.getNextQuestion();
                QuestionManager.printQuestion(question);
                Thread.sleep(1000);
                QuestionManager.printOptions(question.getOptions());
                hourglass.startTimer();

                System.out.println("\nPlease enter your answer:");

                Scanner scan = new Scanner(System.in);
                int userAnswer = Integer.parseInt(scan.nextLine()) - 1;

                if (players.get(0).equals(player)) {
                    hourglass.endTimer(1);
                }
                else {
                    hourglass.endTimer(2);
                }

                if (QuizManager.isCorrectAnswer(question, userAnswer)) {
                    System.out.println("\u001B[32m" + "CORRECT ANSWER!" + "\u001B[32m");
                    if (players.get(0).equals(player)) {
                        player1Correct++;
                    }
                    else {
                        player2Correct++;
                    }
                }
                else {
                    System.out.println("\u001B[31m" + "WRONG ANSWER" + "\u001B[31m");
                }
            }
        }
    }

    public static void comparePoints (Player player1, Player player2) {
        if (player1Correct > player2Correct) {
            player1.addScore();
            System.out.println("\u001B[0m" + "Congratulations " + player1.name + " you won" + "\u001B[0m");
        }
        else if (player1Correct < player2Correct) {
            player2.addScore();
            System.out.println("\u001B[0m" + "Congratulations " + player2.name + " you won" + "\u001B[0m");
        }
        else {
            if (Hourglass.durationTimePlayer1 < Hourglass.durationTimePlayer2) {
                System.out.println("\u001B[0m" + "Even amount of points but " + player1.name + " was " + (Hourglass.durationTimePlayer2 - Hourglass.durationTimePlayer1) + " seconds faster" + "\u001B[0m");
                System.out.println("\u001B[0m" + "Congratulations " + player1.name + " you won" + "\u001B[0m");
                player1.addScore();
            }
            else if (Hourglass.durationTimePlayer1 > Hourglass.durationTimePlayer2) {
                System.out.println("\u001B[0m" + "Even amount of points but " + player2.name + " was " + (Hourglass.durationTimePlayer1 - Hourglass.durationTimePlayer2) + " seconds faster" + "\u001B[0m");
                System.out.println("\u001B[0m" + "Congratulations " + player2.name + " you won" + "\u001B[0m");
                player2.addScore();
            }
            else {
                System.out.println("\u001B[0m" + "Equal time and points, no winner :(" + "\u001B[0m");
            }
        }
    }
}

