package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Option {

    String text;
    boolean isCorrectAnswer;
    public ArrayList<Option> options = new ArrayList<>();

    //för att organisera options
    //Måste finnas en text och en boolean
    Option(String text, boolean isCorrectAnswer){
        this.text = text;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public ArrayList<Option> getText () {
        return options;
    }

   public void setText(){
    this.getText();
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
    public static void printOptions (ArrayList<Option> options) {
        for (Option option: options){
            System.out.println(option.text);
        }
    }
}