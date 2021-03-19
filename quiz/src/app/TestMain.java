package app;
import java.util.Scanner;
import static app.Start.start;

public class TestMain {

    public static void main (String[] args) throws InterruptedException {

        QuestionManager questionManager = new QuestionManager();

        System.out.println("Vilken fråga vill du ta bort?\n");
        Thread.sleep(1000);

        questionManager.load();
        questionManager.printAllQuestions();

        Scanner scan = new Scanner(System.in);
        System.out.print("\nDelete: ");
        Integer index = Integer.parseInt(scan.nextLine())- 1;
        if(questionManager.questions.remove(questionManager.questions.get(index))) {
            System.out.println("Question removed");
            Thread.sleep(5000);
        } else {
            System.out.println("Could not remove question");
        }
        questionManager.save();
        questionManager.printAllQuestions();
        start();
    }
}
