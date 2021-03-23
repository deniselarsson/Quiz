package app;

import java.util.Scanner;

public class Start {

    QuestionManager questionManager = new QuestionManager();
    public void startApp () throws InterruptedException {

            Scanner scanner = new Scanner(System.in);

            Player player1 = new Player();
            Player player2 = new Player();

            System.out.println("---------WELCOME---------");
            System.out.println("[1] PLAY");
            System.out.println("[2] QUIZ OPTIONS");
            System.out.println("[3] EXIT PROGRAM");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    player1 = Player.createPlayer("1");
                    player2 = Player.createPlayer("2");
                    QuizManager.startTheQuiz(player1, player2);

                    Thread.sleep(1000);
                    player1.addPlayed_Games();
                    player2.addPlayed_Games();

                    QuizManager.comparePoints(player1, player2);
                    player1.showStats();
                    player2.showStats();
                    System.out.println();
                    playAgain(player1, player2);
                    break;

                case "2":
                    System.out.println("[1] ADD QUESTION");
                    System.out.println("[2] DELETE QUESTION");
                    System.out.println("[3] LIST ALL QUESTIONS ");
                    int inputNumber = scanner.nextInt();

                    if (inputNumber == 1) {
                        questionManager.load();
                        questionManager.addQuestion();
                        questionManager.save();
                        startApp();
                    }

                    if (inputNumber == 2) {
                        QuestionManager.deleteQuestion();

                        startApp();
                        break;
                    }
                    if (inputNumber == 3) {
                        questionManager.load();
                        questionManager.printAllQuestions();

                        startApp();
                        break;
                    }
                case "3":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input, try again");
            }
        }

        public void playAgain (Player player1, Player player2) throws InterruptedException {
            Scanner scanner = new Scanner(System.in);

            System.out.println("-------------------------");
            System.out.println("[1] PLAY AGAIN");
            System.out.println("[2] QUIZ OPTIONS");
            System.out.println("[3] RETURN TO MAIN MENU");
            System.out.println("[4] EXIT PROGRAM");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    QuizManager.startTheQuiz(player1, player2);

                    Thread.sleep(1000);
                    player1.addPlayed_Games();
                    player2.addPlayed_Games();

                    QuizManager.comparePoints(player1, player2);
                    player1.showStats();
                    player2.showStats();
                    System.out.println();
                    playAgain(player1, player2);
                    break;

                case "2":
                    System.out.println("[1] ADD QUESTION");
                    System.out.println("[2] DELETE QUESTION");
                    System.out.println("[3] LIST ALL QUESTIONS ");
                    int inputNumber = scanner.nextInt();

                    if (inputNumber == 1) {
                        questionManager.load();
                        questionManager.addQuestion();
                        questionManager.save();
                        playAgain(player1, player2);
                    }

                    if (inputNumber == 2) {
                        QuestionManager.deleteQuestion();
                        playAgain(player1, player2);
                        break;
                    }
                    if (inputNumber == 3) {
                        questionManager.load();
                        questionManager.printAllQuestions();
                        playAgain(player1, player2);
                        break;
                    }
                case "3":
                    startApp();
                    break;
                case "4":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input, try again");
            }
        }

    }
