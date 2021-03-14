package serialization;

public class Option {

    String text;
    boolean isCorrectAnswer;

    //för att organisera options
    //Måste finnas en text och en boolean
    Option(String text, boolean isCorrectAnswer){
        this.text = text;
        this.isCorrectAnswer = isCorrectAnswer;
    }
}