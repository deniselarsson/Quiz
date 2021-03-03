package app.serialization;

import app.serialization.Option;

import java.io.Serializable;
import java.util.ArrayList;

//implement the Serializable interface when you need to store a copy of the object,
// send them to another process which runs on the same system or over the network.
//Because you want to store or send an object.It makes storing and sending objects easy.

public class Question implements Serializable {

    //för att organisera listan
    private String text;
    public ArrayList<Option> options = new ArrayList<>();

    public void setText (String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }
    public ArrayList<Option> getOptions () {
        return options;
    }
}