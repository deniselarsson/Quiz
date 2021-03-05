package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

public class Player extends Person {
    // ***** [3] FIRST CASE OPTION FROM startUp ***** //
    /* private variables myScore and myPlayed_Games */
    int myScore;
    int myPlayed_Games;
    /* An arrayList holding class Player named myPlayerList */
    ArrayList<Player> myPlayerList = new ArrayList<>();

    /* A constructor */
    Player(String newName, int newAge, String newMail) {
        super(newName, newAge, newMail);
    }
    /* Overriding the method addPerson from the class Person for adding a new user to arrayList */
    @Override
    public void addPerson() throws IOException {
        /* Objects created from
        a. library class SCANNER named mySc
        b. class GameManager named myGM */
        Scanner mySc = new Scanner(System.in);
        GameManager myGM = new GameManager();
        Timer myT = new Timer();

        /* Asking the user to enter a name */
        System.out.println("User info\nName: ");
        /* Creating a String named aName for reading the users name input */
        String aName = mySc.nextLine();
        /* Telling the program that the input aName equals the variable: name in class Person */
        name = aName;

        /* Asking the user to enter age */
        System.out.println("Age: ");
        /* Creating a int named aAge for reading the users age input */
        int aAge = mySc.nextInt();
        /* Telling the program that the input aAge equals the variable: age in class Person */
        age = aAge;

        /* Asking user to enter mail */
        System.out.println("Mail: ");
        /* Creating a String named aMail for reading the users mail input */
        String aMail = mySc.next();
        /* Telling the program that the input aMail equals the variable: mail in class Person */
        mail = aMail;

        /* Adding the new users name, age and mail to the arrayList holding the class Player. OBS! Need to be serialized with the file Users.md */
        myPlayerList.add(new Player(aName, aAge, aMail));

            }

    /* Enables to send the name, age, mail, score and number of played games to other classes without altering the variables */
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getMail() {
        return mail;
    }
    public int getScore() {
        return myScore;
    }
    public int getPlayed_Games() {
        return myPlayed_Games;
    }
}