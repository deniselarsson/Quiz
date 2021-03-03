package app.serialization;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    private String text;
    public ArrayList<Option> options = new ArrayList<>();

    public void setText (String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }
}