package app.serialization;

public class Option {

    String text;
    boolean isCorrectAnswer;

    //för att organisera options
    Option(String text, boolean isCorrectAnswer){
        this.text = text;
        this.isCorrectAnswer = isCorrectAnswer;
    }
}
