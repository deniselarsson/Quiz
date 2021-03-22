package app;

import java.io.*;

public class FileHandler {

    static Object read (String fileName) throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Object result = in.readObject();
        in.close();
        return result;
    }

    static void write (String fileName, Object object) {
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
}
