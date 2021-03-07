import java.util.Scanner;

public class Helper {

    public static void printText (String text) {
        System.out.println(text);
    }

    public static String scanInput () {

        Scanner input = new Scanner(System.in);
        String scan = input.nextLine();
        return scan;
    }
}