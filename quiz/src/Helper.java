import java.util.Scanner;

public class Helper {

    //Skriver ut text i konsolen
    public static void printText (String text) {
        System.out.println(text);
    }

    //Spara det som skrivs in från konsolen
    public static String scanInput () {

        Scanner input = new Scanner(System.in);
        String scan = input.nextLine();
        return scan;
    }
}