package app;

import java.io.Serializable;
import java.util.ArrayList;

public class Question  implements Serializable {
    private String text;

    // The available options for the question
    private ArrayList<Option> options = new ArrayList<>();

    // Sets the question text
    public void setText (String text) {
        this.text = text;
    }

    // Gets the question text
    public String getText () {
        return text;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }
}
