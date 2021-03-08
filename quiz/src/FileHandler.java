import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    //Läser in filen till minnet
    private static Object read (String fileName) throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Object result = in.readObject();
        in.close();
        return result;
    }

    //Skriver ut objektet  från minnet till en fil
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

    //Läser in frågor från user till filen
    public static ArrayList<Question> readQuestions () {

        try {
            return (ArrayList<Question>) read("questions.txt");
        }
        catch (IOException e) {
            return new ArrayList<>();
        }
        catch (ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    //Skriver frågorna till filen
    public static void writeQuestions (ArrayList<Question> question) {
        write("questions.txt", question);
    }
}
