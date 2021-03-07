import java.util.Scanner;

public class Welcome {

    public static void start () {

        Helper.printText("WELCOME");

        Scanner input = new Scanner(System.in);

        Helper.printText("--------WELCOME!-----------");
        Helper.printText("[1] PLAY");
        Helper.printText("[2] QUIZZES");
        Helper.printText("[3] EXIT");

        int inputNumber = Integer.parseInt(input.nextLine());

        //Om användaren skriver in 1 gå den till metoden play
        if (inputNumber == 1) {
            play();
        }
        //Om användaren skriver in 2 gå den till metoden quizzes
        else if (inputNumber == 2) {
           quizzes();
        }
        //Om användaren skriver in 3 gå den till metoden exit
        else if (inputNumber == 3) {
            exit();
        }
    }

    public static void play(){

        Helper.printText("Player 1:");
        Player.playerInfo();
        Helper.printText("Player 2:");
        Player.playerInfo();
        Helper.printText("The game start!");
    }

    public static void quizzes(){

        Scanner number = new Scanner(System.in);

        Helper.printText("[1] Add question");
        Helper.printText("[2] Delete question");

        int inputNumber = Integer.parseInt(number.nextLine());

        if (inputNumber == 1){
            Question.setNewQuestion();
        }
        if (inputNumber == 2){
            Helper.printText("Which question do you want to delete?");
            Question.printAllQuestions(FileHandler.readQuestions());
        }
    }

    public static void exit(){
        Helper.printText("The game stopped!");
    }
}
