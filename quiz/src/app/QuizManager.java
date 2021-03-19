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

    public static void startTheQuiz () {
        QuestionManager questionManager = new QuestionManager();
        questionManager.load();
        QuizManager quizManager = new QuizManager(questionManager.questions);
        ArrayList<Player> players = new ArrayList<>();

        players.add(Player.createPlayer("1"));
        players.add(Player.createPlayer("2"));

        System.out.println("\n---------The quiz start---------");

        for (int i = 0; i < 3; i++) {
            for (Player player : players) {

                System.out.println("\nPlayer: " + player.name);
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

