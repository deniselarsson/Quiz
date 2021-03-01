package App.suggestion.q;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person {
    private String myName;
    private int myAge;
    private String myMail;
    int myScore;
    int myPlayed_Games;
    ArrayList<Player> myPlayerList = new ArrayList<>();

    Player() {}
    Player(String aName, int aAge, String aMail) {
        myName = aName;
        myAge = aAge;
        myMail = aMail;
    }

    @Override
        public void addPerson() throws IOException {
        Scanner myScan = new Scanner(System.in);
        GameManager myGM = new GameManager();

        System.out.println("Player info\nName: ");
        aName = myScan.nextLine();
        myName = aName;
        System.out.println("Age: ");
        aAge = myScan.nextInt();
        myAge = aAge;
        System.out.println("Mail: ");
        aMail = myScan.next();
        myMail = aMail;

        myPlayerList.add(new Player(aName, aAge, aMail));
        // Få in i filen Users.md för att spara players plus möjligheten att redigera listan (Edit, delete, sort, add?)

        if (aAge >= 0) {
            System.out.println("Welcome " + aName);
            myGM.playOption();
        } else {
            System.out.println( aAge + " cant be an correct age, try again!");
        }
    }

    public String getName() {
        return myName;
    }
    public int getAge() {
        return myAge;
    }
    public String getMail() {
        return myMail;
    }
    public int getScore() {
        return myScore;
    }
    public int getPlayed_Games() {
        return myPlayed_Games;
    }
}
