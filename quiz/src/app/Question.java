package app;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    private String text;
    private ArrayList<Option> options = new ArrayList<>();

    public void setText (String text) {
        this.text = text;
    }
    public String getText () {
        return text;
    }

    public ArrayList<Option> getOptions () {
        return options;
    }
}
