package app;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 @author  By - Denisé Larsson -  Denna klassen hantera quiz
 */
public class QuizManager {

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

    public static void startTheQuiz () throws InterruptedException {
        TidTagare tidTagare = new TidTagare();
        tidTagare.resetTime();

        QuestionManager questionManager = new QuestionManager();
        questionManager.load();
        QuizManager quizManager = new QuizManager(questionManager.questions);
        ArrayList<Player> players = new ArrayList<>();

        players.add(Player.createPlayer("1"));
        players.add(Player.createPlayer("2"));

        System.out.println("\n---------The quiz start---------");

        for (int i = 0; i < 3; i++) {
            for (Player player : players) {

                System.out.println("\u001B[0m" + "\nPlayer: " + player.name + "\u001B[0m");
                Question question = quizManager.getNextQuestion();
                QuestionManager.printQuestion(question);
                Thread.sleep(1000);
                QuestionManager.printOptions(question.getOptions());
                tidTagare.startTimer();

                System.out.println("\nPlease enter your answer:");

                Scanner scan = new Scanner(System.in);
                int userAnswer = Integer.parseInt(scan.nextLine()) - 1;


                if (players.get(0).equals(player)){
                    tidTagare.endTimer(1);
                } else {
                    tidTagare.endTimer(2);
                }


                if (QuizManager.isCorrectAnswer(question, userAnswer)) {
                    System.out.println("\u001B[32m" + "CORRECT ANSWER!" + "\u001B[32m");
                }
                else {
                    System.out.println("\u001B[31m" + "WRONG ANSWER" + "\u001B[31m");
                }
            }
        }
        System.out.println("\u001B[0m" + "tid för player 1: " + tidTagare.durationTimePlayer1 + " sekunder" + "\u001B[0m");
        System.out.println("tid för player 2: " + tidTagare.durationTimePlayer2 + " sekunder");
    }
}

