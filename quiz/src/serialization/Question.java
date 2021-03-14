package serialization;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
//För att frågorna ska kunna serializeras till en fil måste objektet implementera Serializable interface
public class Question implements Serializable {

    private String text;
    public ArrayList<Option> options = new ArrayList<>();

    public void setText (String text) {
        this.text = text;
    }

    public String getText () {
        return text;
    }

    public String toString () {
        return getText();
    }

    //Läser frågan från användaren
    public static String readQuestionText () {

        Scanner scan = new Scanner(System.in);
        System.out.println("Write your question:");
        return scan.nextLine();
    }

    //sätter texten som kommer från användaren
    public static Question createQuestion () {

        Question question = new Question();
        question.setText(readQuestionText());
        return question;
    }

    //Skriv in option till frågan, och om svaret är rätt eller ej, sedan spara detta i en arraylista
    public static ArrayList<Option> createOptions () {

        ArrayList<Option> options = new ArrayList<>();

        for (int i = 0; i < 1; i++) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Write your option: ");
            String text = scan.nextLine();
            System.out.println("Is this the correct answer(Y/N)");
            String y = scan.nextLine();
            Option option = new Option(text, y.equals("y"));
            options.add(option);
        }
        return options;
    }

    //Skriver in den nya frågan + options + om det är rätt eller fel svar till questions filen
    public static void setNewQuestion () {

        ArrayList<Question> questions = FileHandler.readQuestions();
        Question question = createQuestion();
        questions.add(question);
        FileHandler.writeQuestions(questions);
        question.options.addAll(createOptions());
        FileHandler.readQuestions();
    }

    //Skriver ut alla frågor som finns i questions filen
    public static void printAllQuestions (ArrayList<Question> questions) {

        for (Question question : questions) {
            System.out.println(question.getText());
        }
    }
    //Skriver ut en fråga utifrån vilken index jag anropa
    public static void printOneQuestion (ArrayList<Question> questions) {
        System.out.println(questions.get(1));
    }
}