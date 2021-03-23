package app;

import java.io.Serializable;

public class Option implements Serializable {

    private String text;
    private boolean isCorrectAnswer;

    Option (String text, boolean isCorrectAnswer) {
        this.text = text;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public String getText () {
        return text;
    }


    public void setText (String text) {
        this.text = text;
    }


    public void setIsCorrectAnswer (boolean isCorrectAnswer) {
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public boolean getIsCorrectAnswer () {
        return isCorrectAnswer;
    }
}