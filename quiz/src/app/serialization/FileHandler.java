package app.serialization;

import java.io.*;
import java.util.ArrayList;


public class FileHandler {

    //Skicka in en fil questions.txt som serializera
    //läser från filen in i minnet
    private static Object read (String fileName) throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        ;
        Object result = in.readObject();
        in.close();
        return result;
    }

    //skriver ut från minnet
    private static void write (String fileName, Object object) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(object);
            out.flush();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // läser in till questions list
    public static ArrayList<Question> readQuestions () {

        try {
            return (ArrayList<Question>) read("questions.txt");
        }
        //om inte filen finns så returnera den en tom lista
        catch (IOException e) {
            return new ArrayList<>();
        }
        catch (ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
    //den skriver input från console till arraylist question
    public static void writeQuestions (ArrayList<Question> question) {
        write("questions.txt", question);
    }

    // läser in till questions list
    public static ArrayList<Option> readOption () {

        try {
            return (ArrayList<Option>) read("questions.txt");
        }
        //om inte filen finns så returnera den en tom lista
        catch (IOException e) {
            return new ArrayList<>();
        }
        catch (ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
